package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
class rNode{
	String name,duration;

public rNode(String name, String duration) {
	this.name = name;
	this.duration = duration;


}
}



public class analyzeInput extends JDialog{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LinkedList<Node> alist = new LinkedList<Node>();
			analyzeInput dialog = new analyzeInput(alist);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public analyzeInput(LinkedList<Node> alist) {

		LinkedList<rNode> resultList = new LinkedList<rNode>();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));	
		getContentPane().add(contentPanel, BorderLayout.WEST);
		{
			JTextArea activitiesList = new JTextArea("Activities Path('s)");
			contentPanel.add(activitiesList);
			activitiesList.setBounds(50, 50, 150, 150);
			JTextArea durationList = new JTextArea("Duration");
			contentPanel.add(durationList);
			durationList.setBounds(50, 50, 150, 150);
			int duration2,tot_dur;
			for(Node snode : alist) {
				if((snode.isStart) && (!snode.placed)) {
					snode.placed = true;
					rNode thisNode = new rNode(snode.name,snode.duration);
					resultList.add(thisNode);		
				}
			}
				//	if(!snode.isStart) {
				//		for(String str : snode.dep)
				//			for(rNode rn : resultList){
			for(rNode rnode : resultList) {
								for(Node snode1 : alist) {
									for(String str : snode1.dep) {
										if(str.equals(rnode.name)) {
											rNode thisNode = new rNode(snode1.name,snode1.duration);
											String delim = "[>]";
											String[] tokens = rnode.name.split(delim);
											if(tokens[0].equals(str)) {
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
								
	
		}

		
			for(Node chkNode : alist) {
				if(!(chkNode.placed)) {
					JTextField path = new JTextField("");
					path.setBounds(60, 60, 150, 150);
					contentPanel.add(path,BorderLayout.CENTER);
					path.setText("Node not connected");
				}
			}
				//else {
					for(rNode resNode : resultList) {
						JTextField path = new JTextField("");
						path.setBounds(60, 60, 150, 150);
						contentPanel.add(path,BorderLayout.CENTER);
						path.setText(resNode.name);
						JTextArea durations = new JTextArea("");
						durations.setBounds(70, 70, 150, 150);
						contentPanel.add(durations);
						durations.setText(resNode.duration);
				}
		//	}
			//}
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addMouseListener(new MouseAdapter() {			// Add mouse click listener to quit button
					public void mouseClicked(MouseEvent e) {			// Quit routine
						dispose();					}
				});
				getRootPane().setDefaultButton(okButton);
				alist.clear();
			}
//<<<<<<< HEAD
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {			// Add mouse click listener to quit button
					public void mouseClicked(MouseEvent e) {			// Quit routine
						dispose();					}
				});
				buttonPane.add(cancelButton);
			}
//=======
			
//>>>>>>> 0df0c9beb14b76c3beb9e88b6c170eb57d557c05
		}
	}


