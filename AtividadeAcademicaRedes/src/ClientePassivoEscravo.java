import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientePassivoEscravo {

	private String host;
	private int porta;
	private Socket socketCliente;
	PrintStream saida;
	
	private String login;
	private String idJogador1;
	private String idJogador2;
	private String loginJogador1;
	private String loginJogador2;
	private static ClientePassivoEscravo cliente;


	public ClientePassivoEscravo (String host, int porta, String login) {
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
	
	public static synchronized ClientePassivoEscravo getInstance() 
	{
		if (cliente == null) {
			cliente = new ClientePassivoEscravo("127.0.0.1", 11111, "Login");
		}
		return cliente;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getIdJogador1() {
		return idJogador1;
	}

	public void setIdJogador1(String idJogador1) {
		this.idJogador1 = idJogador1;
	}

	public String getIdJogador2() {
		return idJogador2;
	}

	public void setIdJogador2(String idJogador2) {
		this.idJogador2 = idJogador2;
	}

	public String getLoginJogador1() {
		return loginJogador1;
	}

	public void setLoginJogador1(String loginJogador1) {
		this.loginJogador1 = loginJogador1;
	}

	public String getLoginJogador2() {
		return loginJogador2;
	}

	public void setLoginJogador2(String loginJogador2) {
		this.loginJogador2 = loginJogador2;
	}
}
