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
				if(snode.dep == null) {
	
				}
				else {
				}
				path.setText(path.getText() + snode.name + ">");
				int duration = Integer.parseInt(snode.duration);
				tot_dur = tot_dur + duration;
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
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}


