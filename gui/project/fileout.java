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
	public static void main(String[] paths) {
		try {
			LinkedList<Node> alist = new LinkedList<Node>();
			String foo = null;
			fileout dialog = new fileout(alist, foo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public fileout(LinkedList<Node> alist, String foo) {
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
				LinkedList<rNode> resultList = new LinkedList<rNode>();
				int duration2,tot_dur;
				
				for(Node snode : alist) {
					if((snode.isStart) && (!snode.placed)) {
						snode.placed = true;
						rNode thisNode = new rNode(snode.name,snode.duration);
						resultList.add(thisNode);		
					}
				}
				
				for(rNode rnode : resultList) {
					for(Node snode1 : alist) {
						for(String str : snode1.dep) {
							String delim1 = "[,]";
							String tokens1[] = str.split(delim1);
							for(int index = 0;index < tokens1.length;index++) {
								String delim = "[>]";
								String[] tokens = rnode.name.split(delim);
								if(tokens[tokens.length-1].equals(tokens1[index])) {
									snode1.placed = true;
									rnode.name = rnode.name.concat(">");
									rnode.name = rnode.name.concat(snode1.name);
									duration2 = Integer.parseInt(rnode.duration);
									tot_dur = Integer.parseInt(snode1.duration);
									tot_dur = tot_dur + duration2;
									rnode.duration = Integer.toString(tot_dur);
								}

							}
						}
					}
				}





		Date date = new Date();
		String strDate= date.toString();
		String fileName = textField.getText();	// Read text into a string
		String paths = null;				
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
			writer.write(foo);
			writer.newLine();
			writer.newLine();
			writer.write("List of all paths and total durations:");
			writer.newLine();			
			for(rNode resNode : resultList) {
				writer.write(resNode.name + " " + resNode.duration);
				writer.newLine();
			}
			
			
			
			
			
			
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
