package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class reset extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LinkedList<Node> alist = new LinkedList<Node>();
			reset dialog = new reset(alist);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public reset(LinkedList<Node> alist) {
		setBounds(100, 100, 400, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		for(Node node : alist)
		{
			alist.clear();
		}
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(285, 77, 89, 23);
		contentPanel.add(btnNewButton);
		
		JTextArea txtrYourInputHas = new JTextArea();
		txtrYourInputHas.setEditable(false);
		txtrYourInputHas.setText("Your Input has been reset");
		txtrYourInputHas.setBounds(10, 11, 350, 63);
		contentPanel.add(txtrYourInputHas);
		// TODO Auto-generated constructor stub
	}	
}

