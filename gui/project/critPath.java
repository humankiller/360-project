package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class critPath extends JDialog {

	/**
	 * Launch the application.
	 */
	LinkedList<critPathData> clist = new LinkedList<critPathData>();
	private JTextField textField;
	public static void main(String[] args) {
		try {
			LinkedList<Node> alist = new LinkedList<Node>();
			
			critPath dialog = new critPath(alist);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */


	public critPath(LinkedList<Node> alist) {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 299, 146);
		getContentPane().setLayout(null);
		{
			JLabel lblCriticalPath = new JLabel("Critical path(s)");
			lblCriticalPath.setBounds(10, 11, 102, 14);
			getContentPane().add(lblCriticalPath);
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
		
		textField = new JTextField();
		textField.setBounds(10, 29, 263, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
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
		
		
		int longest = 0;
		for(rNode resNode : resultList) {
			if(Integer.parseInt(resNode.duration) >= longest) {
				longest = Integer.parseInt(resNode.duration);
			}
		}
		for(rNode resNode : resultList) {
			if(longest == Integer.parseInt(resNode.duration)) {
				textField.setText(resNode.duration);
			}
		}
	}
}

