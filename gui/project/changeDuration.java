package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changeDuration extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			changeDuration dialog = new changeDuration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public changeDuration() {
		setBounds(100, 100, 249, 193);
		getContentPane().setLayout(null);
		
		JLabel lblWhatNodeDo = new JLabel("What node do you want to change");
		lblWhatNodeDo.setBounds(10, 11, 211, 14);
		getContentPane().add(lblWhatNodeDo);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblWhatIsThe = new JLabel("What is the new duration");
		lblWhatIsThe.setBounds(10, 64, 211, 14);
		getContentPane().add(lblWhatIsThe);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 89, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nodeToUpdate = textField.getText();
				String newDuration = textField_1.getText();
				dispose();
			}
		});
		btnNewButton.setBounds(132, 122, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
