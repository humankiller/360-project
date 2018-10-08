package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class HelpGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpGui frame = new HelpGui();
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
	public HelpGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrAddAppro = new JTextArea();
		txtrAddAppro.setText("Add appropriate info in the text boxes and then press \"enter node\"\r\n\t- be sure that the node name is uniqe\r\n\t- the duration is an integer\r\n\t- the node does not depend on itself\r\nTo clear all nodes press \"reset\"\r\nTo exit program press \"exit\"\r\nTo go back to the main page press \"back\"");
		txtrAddAppro.setBounds(10, 11, 556, 232);
		contentPane.add(txtrAddAppro);
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(10, 276, 89, 23);
		contentPane.add(btnBack);
	}

}
