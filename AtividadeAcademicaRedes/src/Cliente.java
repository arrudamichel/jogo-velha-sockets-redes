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

	public Cliente (String host, int porta) {
		this.host = host;
		this.porta = porta;
	}

	public void executa() throws UnknownHostException, IOException {
		this.socketCliente = new Socket(this.host, this.porta);
		System.out.println("O cliente se conectou ao servidor!");	
	}
	
	public void enviaDados(String dado) throws IOException {
		// lê msgs do teclado e manda pro servidor
		this.saida = new PrintStream(this.socketCliente.getOutputStream());
		
		this.saida.println(dado);
	}
	
	public String recebeDados() throws IOException {
		String retorno = "";	
		InputStream is = this.socketCliente.getInputStream();
		
		// recebe msgs do servidor e imprime na tela
		Scanner s = new Scanner(is);
		
		retorno = s.nextLine();
		
		return retorno;
	}
	
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
}