package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deponself extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			deponself dialog = new deponself();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public deponself() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		{
			JButton btnOk = new JButton("ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOk.setBounds(335, 127, 89, 23);
			getContentPane().add(btnOk);
		}
		
		JTextArea txtrYourNodeCan = new JTextArea();
		txtrYourNodeCan.setText("Your node can not depend upon it self");
		txtrYourNodeCan.setBounds(10, 11, 414, 93);
		getContentPane().add(txtrYourNodeCan);
	}

}
