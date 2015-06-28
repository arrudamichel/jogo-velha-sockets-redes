import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Recebedor implements Runnable {
	Velha velha;
	VelhaPassivo velhaPassivo;
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
			logar(array[1], array[2], array[3]);
			break;

		case "logarPassivo":
			//loginJogador1, idloginJogador1, loginJogador2, idloginJogador2 
			logarPassivo(array[1], array[2], array[3], array[4]);
			break;
			
		case "jogar":
			jogar(array[1], array[2]);
			break;
			
		case "jogarPassivo":
			//idJogador, linha, coluna 
			jogarPassivo(array[1], array[2], array[3]);
			break;
		default:
			break;
		}
	}
	
	public void logar(String id, String loginOponente, String idOponente){
		
		Cliente cliente = Cliente.getInstance();
		cliente.setId(id);	
		cliente.setIdOponente(idOponente);
		System.out.println("ClienteLogin: "+loginOponente);
		System.out.println("MeuloginRecebedor: "+cliente.getLogin());
		
		this.velha = new Velha(cliente.getLogin(), loginOponente, cliente);
		this.velha.show();
	}
	
	public void logarPassivo(String loginJogador1, String idJogador1, String loginJogador2, String idJogador2){
		
		ClientePassivoEscravo clientePassivo = ClientePassivoEscravo.getInstance();
		clientePassivo.setIdJogador1(idJogador1);
		clientePassivo.setIdJogador2(idJogador2);
		clientePassivo.setLoginJogador1(idJogador1);
		clientePassivo.setLoginJogador2(idJogador2);

		
		this.velhaPassivo = new VelhaPassivo(loginJogador1, idJogador1, loginJogador2, idJogador2);
		this.velhaPassivo.show();
	}
	
	public void jogar(String linha, String coluna){
		
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
	
	public void jogarPassivo(String idJogador, String linha, String coluna){
		
		if(this.velhaPassivo.idJogador1 == Integer.parseInt(idJogador)){
			this.velhaPassivo.matrizVelhaBotao[Integer.parseInt(linha)][Integer.parseInt(coluna)].setText("X");
			this.velhaPassivo.matrizVelha[Integer.parseInt(linha)][Integer.parseInt(coluna)] = 1;
			this.velhaPassivo.lblNomeJogador.setText(this.velhaPassivo.nomeJogador2);
		} else {
			this.velhaPassivo.matrizVelhaBotao[Integer.parseInt(linha)][Integer.parseInt(coluna)].setText("O");
			this.velhaPassivo.matrizVelha[Integer.parseInt(linha)][Integer.parseInt(coluna)] = -1;
			this.velhaPassivo.lblNomeJogador.setText(this.velhaPassivo.nomeJogador1);
		}
		
		int retorno = this.velhaPassivo.verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, this.velhaPassivo.nomeJogador1+" venceu o jogo!");
			this.velha.limparVelha();			
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, this.velhaPassivo.nomeJogador2+" venceu o jogo!");
			this.velha.limparVelha();		
		}
	}
}