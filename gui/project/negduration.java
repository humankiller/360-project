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

public class negduration extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			negduration dialog = new negduration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public negduration() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnBack = new JButton("ok");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnBack.setBounds(328, 106, 89, 23);
			contentPanel.add(btnBack);
		}
		{
			JTextArea txtrPleaseEnterA = new JTextArea();
			txtrPleaseEnterA.setEditable(false);
			txtrPleaseEnterA.setText("You must enter a positive value for the duration.\r\n\r\nPlease redo your last input.");
			txtrPleaseEnterA.setBounds(10, 11, 414, 66);
			contentPanel.add(txtrPleaseEnterA);
		}
	}

}
