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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aboutpage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			aboutpage dialog = new aboutpage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public aboutpage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrCreatedByRobert = new JTextArea();
		txtrCreatedByRobert.setText("Created by Robert Holditch, Octavio Lemus, and \r\nNathan Sandri.  The application is meant to take \r\nin nodes, as well as the duration and dependencies \r\nto analyze all paths that are created and list them \r\nalong with their durations.\r\nFor help contact us at:\r\nnsandri@asu.edu\r\nolemus@asu.edu\r\n");
		txtrCreatedByRobert.setBounds(10, 11, 414, 155);
		contentPanel.add(txtrCreatedByRobert);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 217, 89, 23);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
