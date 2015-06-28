
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VelhaPassivo extends JFrame {
	
	public int[][] matrizVelha = {
									  {0, 0, 0},
									  {0, 0, 0},
									  {0, 0, 0}
								  };
	
	private int jogador = 1;
	private JPanel contentPane;
	private JButton button_00 = new JButton("");
	private JButton button_01 = new JButton("");
	private JButton button_02 = new JButton("");
	private JButton button_10 = new JButton("");
	private JButton button_11 = new JButton("");
	private JButton button_12 = new JButton("");
	private JButton button_20 = new JButton("");
	private JButton button_21 = new JButton("");
	private JButton button_22 = new JButton("");
	
	public JButton[][] matrizVelhaBotao = {
			  {button_00, button_01, button_02},
			  {button_10, button_11, button_12},
			  {button_20, button_21, button_22}
		  };
	
	public String nomeJogador1 = "";
	public String nomeJogador2 = "";
	public int idJogador1;
	public int idJogador2;
	private Cliente cliente;

	JLabel lblNomeJogador = new JLabel();
	JLabel lblNomeJogo = new JLabel();
	
	public VelhaPassivo(String loginJogador1, String idJogador1, String loginJogador2, String idJogador2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		this.nomeJogador1 = loginJogador1;
		this.nomeJogador2 = loginJogador2;
		this.idJogador1 = Integer.parseInt(idJogador1);
		this.idJogador2 = Integer.parseInt(idJogador2);
		
		if(this.idJogador1 < this.idJogador2)
			lblNomeJogador.setText(this.nomeJogador1);
		else
			lblNomeJogador.setText(this.nomeJogador2);
		
		lblNomeJogo.setText(this.nomeJogador1 + " X " + this.nomeJogador2);
		
		desabilitaBotoes();
		
		button_00.setBounds(125, 72, 50, 50);
		layeredPane.add(button_00);
		
		button_10.setBounds(125, 133, 50, 50);
		layeredPane.add(button_10);
		
		button_20.setBounds(125, 190, 50, 50);
		layeredPane.add(button_20);
		
		button_11.setBounds(185, 133, 50, 50);
		layeredPane.add(button_11);
		
		button_01.setBounds(185, 72, 50, 50);
		layeredPane.add(button_01);
		
		button_21.setBounds(185, 190, 50, 50);
		layeredPane.add(button_21);
		
		button_02.setBounds(245, 72, 50, 50);
		layeredPane.add(button_02);
		
		button_12.setBounds(245, 133, 50, 50);
		layeredPane.add(button_12);
		
		/*button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_22.getText() != ""){
					return;
				}
				
				int linha = 2;
				int coluna = 2;
				
				matrizVelhaBotao[linha][coluna].setText("O");
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				desabilitaBotoes();
			}
		});*/
		button_22.setBounds(245, 190, 50, 50);
		layeredPane.add(button_22);
		
		JLabel lblJogador = new JLabel("Vez:");
		lblJogador.setBounds(10, 11, 78, 14);
		layeredPane.add(lblJogador);
		
		lblNomeJogador.setBounds(98, 11, 229, 14);
		layeredPane.add(lblNomeJogador);
		
		JLabel lblJogo = new JLabel("Jogo:");
		lblJogo.setBounds(10, 32, 78, 14);
		layeredPane.add(lblJogo);
		
		lblNomeJogo.setBounds(98, 32, 229, 14);
		layeredPane.add(lblNomeJogo);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setBounds(10, 57, 404, 194);
		layeredPane.add(panel);
	}
	
	/*public void recebeOponente(){
		try {
			habilitaBotoes();
			
			
			InputStream is = cliente.getSocketCliente();
			Recebedor recebedor = new Recebedor();
			String dados = cliente.recebeDados();
			
			System.out.println(dados);
			
			String[] array = dados.split(";");
			
			int linha = Integer.parseInt(array[0]);
			int coluna = Integer.parseInt(array[1]);
			
			matrizVelhaBotao[linha][coluna].setText("X");
			
			habilitaBotoes();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void desabilitaBotoes() {
		for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				this.matrizVelhaBotao[i][j].setEnabled(false);
			}
		}	
	}
	
	public void preencheMatriz(int linha, int coluna, int valor) {
		this.matrizVelha[linha][coluna] = valor;
	}
	
	public int verificaMatriz() {		
		int retornoColunas, retornoLinhas, retornoDiagonais = 0;
		retornoColunas = checaColunas();
		retornoLinhas = checaLinhas();
		retornoDiagonais = checaDiagonais();
		
		if(retornoColunas == -1 || retornoLinhas == -1 || retornoDiagonais == -1){
			return -1;
		}
		
		if(retornoColunas == 1 || retornoLinhas == 1 || retornoDiagonais == 1){
			return 1;
		}
		
		for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				if(matrizVelha[i][j] == 0){
					return 0;
				}
			}
		}
		
		limparVelha();
		JOptionPane.showMessageDialog(null, "Jogo empatou!");
		
		return 2;
	}
	
	 public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == -3)
                return -1;
            if( (this.matrizVelha[linha][0] + this.matrizVelha[linha][1] + this.matrizVelha[linha][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
	    
    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == -3)
                return -1;
            if( (this.matrizVelha[0][coluna] + this.matrizVelha[1][coluna] + this.matrizVelha[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checaDiagonais(){
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == -3)
            return -1;
        if( (this.matrizVelha[0][0] + this.matrizVelha[1][1] + this.matrizVelha[2][2]) == 3)
            return 1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == -3)
            return -1;
        if( (this.matrizVelha[0][2] + this.matrizVelha[1][1] + this.matrizVelha[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    /*public int cliqueBotaoVelha(int linha, int coluna) {
    	
    	try {
			cliente.enviaDados("jogar;" + cliente.getId() + ";" + linha + ";" + coluna);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	int valor = 1;

		preencheMatriz(linha, coluna, valor);
		int retorno = verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, nomeJogador+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, nomeOponente+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == 2){
			return 0;
		}
		
		return valor;
    }*/
    
    public void limparVelha(){
    	for(int i=0; i < 3; i++){
			for(int j=0; j < 3; j++){
				matrizVelha[i][j] = 0;				
			}
		}
    	
    	button_00.setText("");
    	button_01.setText("");
    	button_02.setText("");
       	button_10.setText("");
    	button_11.setText("");
    	button_12.setText("");
    	button_20.setText("");
    	button_21.setText("");
    	button_22.setText("");    	
    }
}
