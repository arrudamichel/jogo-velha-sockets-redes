import java.io.PrintStream;


public class ClientePassivo {

	String login;
	int loginId;
	PrintStream loginPS;
	
	String jogardor1;
	int jogador1Id;
	PrintStream jogador1PS;
	
	String jogardor2;
	int jogador2Id;
	PrintStream jogador2PS;
	
	public ClientePassivo() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public PrintStream getLoginPS() {
		return loginPS;
	}

	public void setLoginPS(PrintStream loginPS) {
		this.loginPS = loginPS;
	}

	public String getJogardor1() {
		return jogardor1;
	}

	public void setJogardor1(String jogardor1) {
		this.jogardor1 = jogardor1;
	}

	public int getJogador1Id() {
		return jogador1Id;
	}

	public void setJogador1Id(int jogador1Id) {
		this.jogador1Id = jogador1Id;
	}

	public PrintStream getJogador1PS() {
		return jogador1PS;
	}

	public void setJogador1PS(PrintStream jogador1ps) {
		jogador1PS = jogador1ps;
	}

	public String getJogardor2() {
		return jogardor2;
	}

	public void setJogardor2(String jogardor2) {
		this.jogardor2 = jogardor2;
	}

	public int getJogador2Id() {
		return jogador2Id;
	}

	public void setJogador2Id(int jogador2Id) {
		this.jogador2Id = jogador2Id;
	}

	public PrintStream getJogador2PS() {
		return jogador2PS;
	}

	public void setJogador2PS(PrintStream jogador2ps) {
		jogador2PS = jogador2ps;
	}
}
