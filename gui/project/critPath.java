package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class critPath extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			critPath dialog = new critPath();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public critPath() {
		setBounds(100, 100, 299, 146);
		getContentPane().setLayout(null);
		{
			JLabel lblCriticalPath = new JLabel("Critical path(s)");
			lblCriticalPath.setBounds(10, 11, 102, 14);
			getContentPane().add(lblCriticalPath);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(10, 36, 263, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("Ok");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(184, 73, 89, 23);
			getContentPane().add(btnNewButton);
		}
	}

}

