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


public class analyzeInput extends JDialog{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			String thisName,thisDuration;
			String[] thisDep;

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
			JTextArea path = new JTextArea("");
	
			path.setBounds(60, 60, 150, 150);
			contentPanel.add(path);
			int tot_dur = 0;
			
			for(Node snode : alist) {
				//if(snode.dep.length ==0) {
				//	path.setText(path.getText() + snode.name + ">");
				//	int duration = Integer.parseInt(snode.duration);
				//	tot_dur = tot_dur + duration;

				//}
				//else {
					for(String str : snode.dep) {
						if(str.isEmpty()) {
							Node thisNode = new Node(snode.name,snode.duration,snode.dep);
							boolean isRemoved = alist.remove(snode);
							path.setText(path.getText() + thisNode.name + ">");
							int duration = Integer.parseInt(thisNode.duration);
							tot_dur = tot_dur + duration;
						//}
						//else {
							for(Node snode2 : alist) {
								//if(snode2.name.equals(snode.name)) {
								//}
								//else	
								for(String str2 : snode2.dep) {
									if(str2.equals(thisNode.name)) {
										path.setText(path.getText() + snode2.name + ">");
										int duration2 = Integer.parseInt(snode2.duration);
										tot_dur = tot_dur + duration;
										str2 = "";
						}}
							}}
				}
				//path.setText(path.getText() + snode.name + ">");
				//for(String str : snode.dep) {
				//	path.setText(path.getText() + str + " ");
				//}
				//int duration = Integer.parseInt(snode.duration);
				//tot_dur = tot_dur + duration;

			}
			JTextArea durations = new JTextArea("");
			durations.setBounds(70, 70, 150, 150);
			contentPanel.add(durations);
			durations.setText(String.valueOf(tot_dur));
			
			}
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


