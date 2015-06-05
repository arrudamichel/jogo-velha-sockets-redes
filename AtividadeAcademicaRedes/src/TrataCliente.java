import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;


public class TrataCliente implements Runnable {

	private InputStream cliente = null;
	private Servidor servidor = null;
	private ClienteServidor clienteServidor = null;

	public TrataCliente(InputStream cliente, Servidor servidor, ClienteServidor clienteServidor) {
		this.cliente = cliente;
		this.servidor = servidor;
		this.clienteServidor = clienteServidor;
	}

	public void run() {
		// quando chegar uma msg, distribui pra todos
		Scanner s = new Scanner(this.cliente);

		while (s.hasNextLine()) {
			String entrada = s.nextLine();
			this.trataEntrada(entrada);

			//servidor.distribuiMensagem(s.nextLine());
		}
		s.close();
	}
	
	public void trataEntrada(String entrada){
		String[] array = entrada.split(";");

		switch (array[0]) {
		case "logar":
			Logar(array[1]);
			break;

		case "jogar":
			Jogar(array[1], array[2], array[3]);
			break;
		default:
			break;
		}
	}
	
	public void Logar(String login){
		
		this.clienteServidor.setLogin(login);
		
		Map<Integer, ClienteServidor> clientes = this.servidor.clientes;
		
		for(int key : clientes.keySet()){
			if(clientes.get(key).getOponente() == null && !clientes.get(key).getLogin().equals(login)){
				
				//Inclui Oponente player dois
				this.clienteServidor.setOponente(clientes.get(key).getLogin());
				this.clienteServidor.setOponentePS(clientes.get(key).getLoginPS());
				this.clienteServidor.setOponenteId(key);

				//Inclui Oponente player um que estava a espera e foi achado na lista				
				clientes.get(key).setOponente(this.clienteServidor.getLogin());
				clientes.get(key).setOponentePS(this.clienteServidor.getLoginPS());
				clientes.get(key).setOponenteId(this.clienteServidor.getLoginId());
				
				//Retorna Oponente de cada Login
				servidor.distribuiMensagem(this.clienteServidor.getLoginPS(), this.clienteServidor.getLoginId() +";"+ clientes.get(key).getLogin());
				servidor.distribuiMensagem(clientes.get(key).getLoginPS(), clientes.get(key).getLoginId() +";"+ this.clienteServidor.getLogin());
			}
		}
		
		
	}
	
	public void Jogar(String id, String linha, String coluna){
		
		ClienteServidor cliente = this.servidor.clientes.get(id);
		
		servidor.distribuiMensagem(cliente.getOponentePS(), linha + ";" + coluna);
	}
}
