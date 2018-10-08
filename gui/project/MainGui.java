package project;
// Default packages
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
// Our packages
import java.io.*;
import project.input;
import project.actionListener;
import project.gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGui {

	private JFrame frame;
	private JFrame HelpFrame;
	private JFrame AboutFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Create the application. 
	public MainGui() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(460, 135, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblActivityName = new JLabel("Activity Name");
		lblActivityName.setBounds(10, 15, 106, 14);
		frame.getContentPane().add(lblActivityName);
		
		textField = new JTextField();
		textField.setBounds(10, 40, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(155, 11, 83, 23);
		frame.getContentPane().add(lblDuration);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 40, 129, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDependancies = new JLabel("Dependancies");
		lblDependancies.setBounds(291, 15, 98, 14);
		frame.getContentPane().add(lblDependancies);
		
		textField_2 = new JTextField();
		textField_2.setBounds(291, 40, 275, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(460, 276, 106, 23);
		frame.getContentPane().add(btnQuit);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutGui About = new AboutGui();
				About.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 252, 106, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HelpGui Help = new HelpGui();
				Help.setVisible(true);
			}
		});
		btnHelp.setBounds(10, 276, 106, 23);
		frame.getContentPane().add(btnHelp);
		
		JButton btnEnterNode = new JButton("Enter node");
		btnEnterNode.setBounds(460, 71, 106, 23);
		frame.getContentPane().add(btnEnterNode);
		
		JButton btnAnalyze = new JButton("Analyze");
		btnAnalyze.setBounds(460, 101, 106, 23);
		frame.getContentPane().add(btnAnalyze);
		
		JLabel lblNodesAdded = new JLabel("Nodes Added:");
		lblNodesAdded.setBounds(10, 75, 88, 14);
		frame.getContentPane().add(lblNodesAdded);
	}
}
