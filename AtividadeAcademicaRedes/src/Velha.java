
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.Canvas;

import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Velha extends JFrame {
	
	private int[][] matrizVelha = {
									  {0, 0, 0},
									  {0, 0, 0},
									  {0, 0, 0}
								  };
	private int jogador = 1;
	private JPanel contentPane;
	private JButton button_00;
	private JButton button_01;
	private JButton button_02;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	
	private String nomeJogador1 = "Michel";
	private String nomeJogador2 = "Manoel";

	JLabel lblNomeJogador = new JLabel();
	JLabel lblNomeJogo = new JLabel();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Velha frame = new Velha("Michel");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param nomeJogador 
	 */
	public Velha(String nomeJogador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		lblNomeJogador.setText(nomeJogador);
		lblNomeJogador.setText(nomeJogador + " X " + nomeJogador2);
		
		button_00 = new JButton("");
		button_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_00.getText() != ""){
					return;
				}
				
				int linha = 0;
				int coluna = 0;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_00.setText("O");
				}else if(valor == -1){
					button_00.setText("X");
				}
			}
		});
		button_00.setBounds(125, 72, 50, 50);
		layeredPane.add(button_00);
		
		button_10 = new JButton("");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_10.getText() != ""){
					return;
				}
				
				int linha = 1;
				int coluna = 0;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_10.setText("O");
				}else if(valor == -1){
					button_10.setText("X");
				}
			}
		});
		button_10.setBounds(125, 133, 50, 50);
		layeredPane.add(button_10);
		
		button_20 = new JButton("");
		button_20.setBounds(125, 190, 50, 50);
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_20.getText() != ""){
					return;
				}
				
				int linha = 2;
				int coluna = 0;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_20.setText("O");
				}else if(valor == -1){
					button_20.setText("X");
				}
			}
		});
		layeredPane.add(button_20);
		
		button_11 = new JButton("");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_11.getText() != ""){
					return;
				}
				
				int linha = 1;
				int coluna = 1;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_11.setText("O");
				}else if(valor == -1){
					button_11.setText("X");
				}
			}
		});
		button_11.setBounds(185, 133, 50, 50);
		layeredPane.add(button_11);
		
		button_01 = new JButton("");
		button_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_01.getText() != ""){
					return;
				}
				
				int linha = 0;
				int coluna = 1;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_01.setText("O");
				}else if(valor == -1){
					button_01.setText("X");
				}
			}
		});
		button_01.setBounds(185, 72, 50, 50);
		layeredPane.add(button_01);
		
		button_21 = new JButton("");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_21.getText() != ""){
					return;
				}
				
				int linha = 2;
				int coluna = 1;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_21.setText("O");
				}else if(valor == -1){
					button_21.setText("X");
				}
			}
		});
		button_21.setBounds(185, 190, 50, 50);
		layeredPane.add(button_21);
		
		button_02 = new JButton("");
		button_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_02.getText() != ""){
					return;
				}
				
				int linha = 0;
				int coluna = 2;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_02.setText("O");
				}else if(valor == -1){
					button_02.setText("X");
				}
			}
		});
		button_02.setBounds(245, 72, 50, 50);
		layeredPane.add(button_02);
		
		button_12 = new JButton("");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_12.getText() != ""){
					return;
				}
				
				int linha = 1;
				int coluna = 2;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_12.setText("O");
				}else if(valor == -1){
					button_12.setText("X");
				}
			}
		});
		button_12.setBounds(245, 133, 50, 50);
		layeredPane.add(button_12);
		
		button_22 = new JButton("");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(button_22.getText() != ""){
					return;
				}
				
				int linha = 2;
				int coluna = 2;
				
				int valor = cliqueBotaoVelha(linha, coluna);
				
				if(valor == 1){
					button_22.setText("O");
				}else if(valor == -1){
					button_22.setText("X");
				}
			}
		});
		button_22.setBounds(245, 190, 50, 50);
		layeredPane.add(button_22);
		
		JLabel lblJogador = new JLabel("Jogador:");
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
    
    public int cliqueBotaoVelha(int linha, int coluna){
    	int valor = 0;
    	
    	if(jogador == 1){					
			valor = 1;
			jogador = -1;					
			lblNomeJogador.setText(nomeJogador2);
		}				
		else if (jogador == -1){
			valor = -1;
			jogador = 1;
			lblNomeJogador.setText(nomeJogador1);
		}

		preencheMatriz(linha, coluna, valor);
		int retorno = verificaMatriz();
		if(retorno == 1){
			JOptionPane.showMessageDialog(null, nomeJogador1+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == -1){
			JOptionPane.showMessageDialog(null, nomeJogador2+" venceu o jogo!");
			limparVelha();
			return 0;
		}else if(retorno == 2){
			return 0;
		}
		
		return valor;
    }
    
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
