import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Recebedor implements Runnable {
	Velha velha;
	private InputStream servidor;

	public Recebedor(InputStream servidor) {
		this.servidor = servidor;
	}

	public void run() {
		Scanner s = new Scanner(servidor);

		while (s.hasNextLine()) {
			String entrada = s.nextLine();
			this.trataEntrada(entrada);
			System.out.println(entrada);
			//servidor.distribuiMensagem(s.nextLine());
		}
	}
	
	public void trataEntrada(String entrada){
		String[] array = entrada.split(";");

		switch (array[0]) {
		case "logar":
			//Id, loginOponente, idOponente 
			Logar(array[1], array[2], array[3]);
			break;

		case "jogar":
			Jogar(array[1], array[2]);
			break;
		default:
			break;
		}
	}
	
	public void Logar(String id, String loginOponente, String idOponente){
		
		Cliente cliente = Cliente.getInstance();
		cliente.setId(id);	
		cliente.setIdOponente(idOponente);
		System.out.println("ClienteLogin: "+loginOponente);
		System.out.println("MeuloginRecebedor: "+cliente.getLogin());
		
		this.velha = new Velha(cliente.getLogin(), loginOponente, cliente);
		this.velha.show();
	}
	
	public void Jogar(String linha, String coluna){
		
		this.velha.matrizVelhaBotao[Integer.parseInt(linha)][Integer.parseInt(coluna)].setText("X");
		this.velha.matrizVelha[Integer.parseInt(linha)][Integer.parseInt(coluna)] = -1;
		
		int retorno = this.velha.verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, this.velha.nomeJogador+" venceu o jogo!");
			this.velha.limparVelha();			
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, this.velha.nomeOponente+" venceu o jogo!");
			this.velha.limparVelha();		
		}
		
		this.velha.habilitaBotoes();
		
	}
}