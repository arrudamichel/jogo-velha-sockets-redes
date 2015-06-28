import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	private String host;
	private int porta;
	private Socket socketCliente;
	PrintStream saida;
	private String id;
	private String idOponente;
	private String login;
	private static Cliente cliente;


	public Cliente (String host, int porta, String login) {
		this.host = host;
		this.porta = porta;
		this.login = login;
		cliente = this;
	}

	public void executa() throws UnknownHostException, IOException {
		this.socketCliente = new Socket(this.host, this.porta);
		System.out.println("O cliente se conectou ao servidor!");
		
		InputStream is = this.socketCliente.getInputStream();
		Recebedor rec = new Recebedor(is);
		Thread t = new Thread(rec);
		t.start();
	}
	
	public void enviaDados(String dado) throws IOException {
		// lê msgs do teclado e manda pro servidor
		this.saida = new PrintStream(this.socketCliente.getOutputStream());
		
		this.saida.println(dado);
	}
	
	/*public String recebeDados() throws IOException {
		String retorno = "";	
		InputStream is = this.socketCliente.getInputStream();
		
		// recebe msgs do servidor e imprime na tela
		Scanner s = new Scanner(is);
		
		retorno = s.nextLine();
		
		return retorno;
	}*/
	
	public void fechaConexao() throws IOException{
		this.saida.close();
		this.socketCliente.close();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdOponente() {
		return idOponente;
	}

	public void setIdOponente(String idOponente) {
		this.idOponente = idOponente;
	}
	
	public static synchronized Cliente getInstance() 
	{
		if (cliente == null) {
			cliente = new Cliente("127.0.0.1", 11111, "Login");
		}
		return cliente;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
}
