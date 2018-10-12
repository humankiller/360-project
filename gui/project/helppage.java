package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class helppage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			helppage dialog = new helppage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public helppage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrAddAppropriateInfo = new JTextArea();
			txtrAddAppropriateInfo.setEditable(false);
			txtrAddAppropriateInfo.setBounds(10, 11, 414, 148);
			txtrAddAppropriateInfo.setText("Add appropriate info in the text boxes and then\r\npress \"enter node\"\r\n\t- be sure that the node name is uniqe\r\n\t- the duration is an integer\r\n\t- the node does not depend on itself\r\nTo clear all nodes press \"reset\"\r\nTo exit program press \"exit\"\r\nTo go back to the main page press \"back\"");
			contentPanel.add(txtrAddAppropriateInfo);
		}
		{
			JButton btnBack = new JButton("back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnBack.setBounds(335, 228, 89, 23);
			contentPanel.add(btnBack);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
