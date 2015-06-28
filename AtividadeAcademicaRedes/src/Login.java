
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
	public static JTextField txtNomeJogador;
	private JButton btnJogar;
	private JLabel lblEntreComSeu;
	private JButton btnOlhar;
	private JLayeredPane layeredPane;
	private final JLabel lblCarregando;
	private Cliente cliente;
	private JTextField ipServidor;
	private JTextField portaServidor;

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
		lblCarregando.setBounds(10, 226, 246, 14);
		layeredPane.add(lblCarregando);
		
		txtNomeJogador = new JTextField();
		txtNomeJogador.setBounds(10, 36, 404, 20);
		layeredPane.add(txtNomeJogador);
		txtNomeJogador.setColumns(10);
		
		btnJogar = new JButton("Jogar");
		btnJogar.setBounds(325, 188, 89, 23);
		layeredPane.add(btnJogar);
		
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cliente = new Cliente(ipServidor.getText(), Integer.parseInt(portaServidor.getText()), txtNomeJogador.getText());
					cliente.executa();
					cliente.enviaDados("logar;"+txtNomeJogador.getText());
					
					lblCarregando.setVisible(true);
					JOptionPane.showMessageDialog(null, "Conectado !");
		
				} catch (IOException e) {
					lblCarregando.setVisible(false);
					JOptionPane.showMessageDialog(null, "Erro na conexão!");
					e.printStackTrace();
				}
			}
		});
		
		btnOlhar = new JButton("Olhar");
		btnOlhar.setBounds(226, 188, 89, 23);
		layeredPane.add(btnOlhar);		
		
		ipServidor = new JTextField();
		ipServidor.setColumns(10);
		ipServidor.setBounds(10, 92, 404, 20);
		layeredPane.add(ipServidor);
		
		JLabel lblEntreComIp = new JLabel("Entre com ip do servidor:");
		lblEntreComIp.setBounds(10, 67, 167, 14);
		layeredPane.add(lblEntreComIp);
		
		portaServidor = new JTextField();
		portaServidor.setColumns(10);
		portaServidor.setBounds(10, 157, 404, 20);
		layeredPane.add(portaServidor);
		
		JLabel lblEntreComA = new JLabel("Entre com a porta:");
		lblEntreComA.setBounds(10, 132, 167, 14);
		layeredPane.add(lblEntreComA);
		
		btnOlhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					cliente = new Cliente(ipServidor.getText(), Integer.parseInt(portaServidor.getText()), txtNomeJogador.getText());
					cliente.executa();
					cliente.enviaDados("logarPassivo;"+txtNomeJogador.getText());
					
					lblCarregando.setVisible(true);
					JOptionPane.showMessageDialog(null, "Conectado !");
		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					lblCarregando.setVisible(false);
					JOptionPane.showMessageDialog(null, "Erro na conexão!");
					e.printStackTrace();
				}
			}
		});
	}
}
