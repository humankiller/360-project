package project;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.awt.event.ActionEvent;

public class fileout extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			fileout dialog = new fileout();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public fileout() {
		setBounds(100, 100, 317, 159);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPleaseEnterA = new JLabel("Please Enter A File Name");
		lblPleaseEnterA.setBounds(10, 11, 141, 14);
		contentPanel.add(lblPleaseEnterA);
		
		textField = new JTextField();
		textField.setBounds(10, 38, 141, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String strDate= date.toString();
				String fileName = textField.getText();	// Read text into a string
				PrintWriter outputFile = null;
				try {
					outputFile = new PrintWriter(fileName + ".txt");
				} catch (FileNotFoundException error) {
					error.printStackTrace();
				}
				BufferedWriter writer = new BufferedWriter(outputFile);
				try {
					writer.write("File Name: " + fileName);
					writer.newLine();
					writer.write(strDate);
					writer.newLine();
					writer.newLine();
					writer.write("List of all activities:");
					writer.newLine();
					writer.newLine();
					// act logic
					writer.newLine();
					writer.newLine();
					writer.write("List of all paths and total durations:");
					writer.newLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				try {
					writer.close();
					outputFile.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setBounds(202, 86, 89, 23);
		contentPanel.add(btnNewButton);
	}
}
