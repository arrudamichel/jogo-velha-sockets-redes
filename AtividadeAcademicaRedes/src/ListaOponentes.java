
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaOponentes extends JFrame {

	private JPanel contentPane;
	List list = new List();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaOponentes frame = new ListaOponentes();
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
	public ListaOponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblListaOponentes = new JLabel("Escolha um oponente:");
		lblListaOponentes.setBounds(10, 11, 239, 14);
		layeredPane.add(lblListaOponentes);				
		
		list.setBounds(10, 31, 404, 186);
		list.add("Michel");
		list.add("Manoel");
		layeredPane.add(list);
		
		Button buttonJogar = new Button("Jogar");
		buttonJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, list.getSelectedItem());
			}
		});
		buttonJogar.setBounds(344, 223, 70, 22);
		layeredPane.add(buttonJogar);
				
	}
}
