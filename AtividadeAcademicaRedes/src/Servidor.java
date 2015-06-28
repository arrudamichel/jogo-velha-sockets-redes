import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Servidor {
	public static void main(String[] args) throws IOException {
		// inicia o servidor
		new Servidor(11111).executa();
	}

	private int porta;
	public Map<Integer, ClienteServidor> clientes;
	private static int idCliente = 0; 

	public Servidor (int porta) {
		this.porta = porta;
		//this.clientes = new ArrayList<PrintStream>();
		this.clientes = new HashMap<Integer,ClienteServidor>();  
	}

	public void executa() throws IOException {
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta 11111 aberta!");

		while (true) {
			// aceita um cliente
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

			// adiciona saida do cliente à lista
			PrintStream ps = new PrintStream(cliente.getOutputStream());			
			ClienteServidor cs = new ClienteServidor();
			cs.setLoginPS(ps);
			this.idCliente++;
			cs.setLoginId(this.idCliente);
			this.clientes.put(this.idCliente, cs);

			// cria tratador de cliente numa nova thread
			TrataCliente tc = new TrataCliente(cliente.getInputStream(), this, cs);
			Thread t = new Thread(tc);
			t.start();
		}
	}

	public void distribuiMensagem(PrintStream cliente, String msg) {
		
		System.out.println(msg);
		
		cliente.println(msg);		
	}
}
