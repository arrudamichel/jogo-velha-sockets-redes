
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeJogador;
	private JButton btnJogar;
	private JLabel lblEntreComSeu;
	private JButton btnOlhar;
	private JLayeredPane layeredPane;
	private final JLabel lblCarregando;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		lblEntreComSeu = new JLabel("Entre com seu apelido:");
		lblEntreComSeu.setBounds(10, 11, 167, 14);
		layeredPane.add(lblEntreComSeu);
		
		lblCarregando = new JLabel("Aguardando um oponente se conectar...");
		lblCarregando.setVisible(false);
		lblCarregando.setBounds(10, 118, 246, 14);
		layeredPane.add(lblCarregando);
		
		txtNomeJogador = new JTextField();
		txtNomeJogador.setBounds(10, 36, 404, 20);
		layeredPane.add(txtNomeJogador);
		txtNomeJogador.setColumns(10);
		
		btnJogar = new JButton("Jogar");
		btnJogar.setBounds(325, 84, 89, 23);
		layeredPane.add(btnJogar);
		
		btnJogar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String dados = "";
				String[] array = null;
				try {
									
					cliente = new Cliente("127.0.0.1", 12345);
					cliente.executa();
					
					cliente.enviaDados("logar;"+txtNomeJogador.getText());
					
					
					lblCarregando.setVisible(true);
					JOptionPane.showMessageDialog(null, "Conectado !");
					
					dados = cliente.recebeDados();
					
					lblCarregando.setVisible(false);
					
					array = dados.split(";");
					
					cliente.setId(array[0]);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					lblCarregando.setVisible(false);
					JOptionPane.showMessageDialog(null, "Erro na conexão!");
					e.printStackTrace();
				}
				
				Velha velha = new Velha(txtNomeJogador.getText(), array[1], cliente);
				velha.show();
			}
		});
		
		btnOlhar = new JButton("Olhar");
		btnOlhar.setBounds(226, 84, 89, 23);
		layeredPane.add(btnOlhar);		
		
		btnOlhar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				/*String oponente = "";
				try {
					
					Cliente cliente = new Cliente("127.0.0.1", 12345);
					cliente.executa();
					
					cliente.enviaDados("logar;"+txtNomeJogador.getText());
					
					oponente = cliente.recebeDados();
					
					System.out.println("Oponente = "+oponente);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Velha velha = new Velha(txtNomeJogador.getText(), oponente);
				velha.show();*/
			}
		});
	}
}
