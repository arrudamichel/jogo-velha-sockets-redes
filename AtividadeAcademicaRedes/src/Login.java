
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeJogador;
	private JButton btnJogar;
	private JLabel lblEntreComSeu;
	private JButton btnOlhar;
	private JLayeredPane layeredPane;

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
				Velha velha = new Velha(txtNomeJogador.getText());
				velha.show();
			}
		});
		
		btnOlhar = new JButton("Olhar");
		btnOlhar.setBounds(226, 84, 89, 23);
		layeredPane.add(btnOlhar);
	}
}
