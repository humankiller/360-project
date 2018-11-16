package project;
// Default packages
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Node{
	String name,duration;
	String[] dep;
	boolean isStart, placed;
public Node(String name, String duration, String[] dep,boolean isStart, boolean placed) {
	this.name = name;
	this.duration = duration;
	this.dep = dep;
	this.isStart = isStart;
	this.placed = placed;
}
}


public class MainGui {
	analyzeInput ai;
	private JFrame frame;
	private JFrame HelpFrame;
	private JFrame AboutFrame;
	private JFrame AiFrame;
	private JFrame fileOut;
	private JTextField textField;
	private JTextField txtEnterAnInteger;
	private JTextField textField_2;
	private JTextField textField_3;
	
	//***********************
	//***Start the program***
	//***********************
	public static void main(String[] args) {					// Main
		EventQueue.invokeLater(new Runnable() {					// Queue the program to run
			public void run() {									// Run the program
				try {											// Try to create the gui window
					MainGui window = new MainGui();				// Creates object for gui
					window.frame.setVisible(true);				// Makes gui visible
				} catch (Exception e) {							// Catch failed attempt to create and show gui
					e.printStackTrace();						// Print out failure
				}
			}
		});

	}

	 LinkedList<Node> list = new LinkedList<Node>();
	
	//**************************************
	//***Creates the original program gui***
	//**************************************
	public MainGui() {											// Initialize the main gui

		initialize();											// Run initialize

	}

	//**************************************
	//***Puts all elements onto the frame***
	//**************************************
	private void initialize() {									
		frame = new JFrame();									// Create new frame
		frame.setBounds(100, 100, 592, 349);					// Give size for frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Make the frame exit the program on close
		frame.getContentPane().setLayout(null);					// Make there be no default layout
		
		JButton btnNewButton = new JButton("Reset");			// Create reset button
		btnNewButton.addMouseListener(new MouseAdapter() {		// Add mouse click listener to reset button
			public void mouseClicked(MouseEvent arg0) {			// Reset routine
				reset rst = new reset(list);					// Create reset object
				rst.setVisible(true);
				textField_3.setText(null);
			}
		});
		btnNewButton.setBounds(437, 252, 129, 23);				// Give the button size
		frame.getContentPane().add(btnNewButton);				// Add the button to the frame
		
		JLabel lblActivityName = new JLabel("Activity Name");	// Create a label
		lblActivityName.setBounds(10, 15, 106, 14);				// Set label size
		frame.getContentPane().add(lblActivityName);			// Add label to frame
		
		textField = new JTextField();							// Create a new text field
		textField.setBounds(10, 40, 129, 20);					// Give the field a size
		frame.getContentPane().add(textField);					// Add the field to the frame
		textField.setColumns(10);								// Set the number of columns
		
		JLabel lblDuration = new JLabel("Duration");			// Create a label
		lblDuration.setBounds(155, 11, 83, 23);					// Give the field a size
		frame.getContentPane().add(lblDuration);				// Add the field to the frame
		
		txtEnterAnInteger = new JTextField();					// Create a new text field
		txtEnterAnInteger.setBounds(152, 40, 129, 20);			// Give the field a size
		frame.getContentPane().add(txtEnterAnInteger);			// Add the field to the frame
		txtEnterAnInteger.setColumns(10);						// Set the number of columns
		
		JLabel lblDependancies = new JLabel("Dependancies");	// Create a label
		lblDependancies.setBounds(291, 15, 98, 14);				// Give the field a size
		frame.getContentPane().add(lblDependancies);			// Add the field to the frame
		
		textField_2 = new JTextField();							// Create a new text field
		textField_2.setBounds(291, 40, 275, 20);				// Give the field a size
		frame.getContentPane().add(textField_2);				// Add the field to the frame
		textField_2.setColumns(10);								// Set the number of columns
		
		JButton btnQuit = new JButton("Quit");					// Create quit button
		btnQuit.addMouseListener(new MouseAdapter() {			// Add mouse click listener to quit button
			public void mouseClicked(MouseEvent e) {			// Quit routine
				System.exit(0);									// Exit the program
			}
		});
		btnQuit.setBounds(437, 276, 129, 23);					// Give the button size
		frame.getContentPane().add(btnQuit);					// Add the button to the frame
		
		JButton btnNewButton_1 = new JButton("About");			// Create about button
		btnNewButton_1.addMouseListener(new MouseAdapter() {	// Add mouse click listener to about button
			public void mouseClicked(MouseEvent e) {			// About routine
				aboutpage About = new aboutpage();				// Create aboutpage object
				About.setVisible(true);							// Make the object visible
			}
		});
		btnNewButton_1.setBounds(10, 252, 129, 23);				// Give the button size
		frame.getContentPane().add(btnNewButton_1);				// Add the button to the frame
		
		JButton btnHelp = new JButton("Help");					// Create help button
		btnHelp.addMouseListener(new MouseAdapter() {			// Add mouse click listener to help button
			public void mouseClicked(MouseEvent e) {			// Help routine
				helppage Help = new helppage();					// Create helppage object
				Help.setVisible(true);							// Make the object visible
			}
		});
		btnHelp.setBounds(10, 276, 129, 23);					// Give the button size
		frame.getContentPane().add(btnHelp);					// Add the button to the frame
		
		JButton btnEnterNode = new JButton("Enter Node");		// Create enter node button
		btnEnterNode.addMouseListener(new MouseAdapter() {		// Add mouse click listener to enter node button
			public void mouseClicked(MouseEvent e) {			// Enter node routine
			
			
				// will check the duration field for an integer
				String durationStr = txtEnterAnInteger.getText();	// Read text into a string
				try {												// Try to cast to an int
					int duration = Integer.parseInt(durationStr);	// Cast to int
					if (duration < 0) {								// If it is a negative int
						negduration negDur = new negduration();		// Create negduration object
						negDur.setVisible(true);					// Make the object visible
					}
				} catch (Exception badInt) {						// Catch when input is not able to be cast as an int
					nonintduration nonInt = new nonintduration();	// Create nonintduration object
					nonInt.setVisible(true);						// Make the object visable
				}
				String name = textField.getText();					// node name
				String dep = textField_2.getText();					// node dependancies
				String delim = "[,]";								// common delimiter
				String[] tokens = dep.split(delim);					// create an array by splitting on delim
				boolean isStart = false;
				boolean placed = false;

				if (new String(dep).equals(name)) {
					textField.setText(null);
					textField_2.setText(null);
					txtEnterAnInteger.setText(null);
					deponself badDep= new deponself();
					badDep.setVisible(true);
				}
				else {
					textField_3.setText(textField_3.getText() + name + ",");
					if(new String(dep).isEmpty()) {
						isStart = true;
					}
					list.add(new Node(name,durationStr,tokens,isStart,placed));
					textField.setText(null);
					txtEnterAnInteger.setText(null);					// Clear the text field
					textField_2.setText(null);
				}

				//textField_3.setText(textField_3.getText() + name + ",");
				//list.add(new Node(name,durationStr,tokens));
				//textField.setText(null);
				//txtEnterAnInteger.setText(null);					// Clear the text field
				//textField_2.setText(null);

			}

		});

		btnEnterNode.setBounds(301, 71, 126, 23);					// Give the button size
		frame.getContentPane().add(btnEnterNode);					// Add the button to the frame
		
		JButton btnAnalyze = new JButton("Analyze");				// Create the analyze button
		btnAnalyze.setBounds(437, 139, 129, 23);					// Give the button size
		frame.getContentPane().add(btnAnalyze);						// Add the button to the frame
		btnAnalyze.addMouseListener(new MouseAdapter() {			// Add mouse click listener to enter node button
			public void mouseClicked(MouseEvent e) {
				analyzeInput Ai = new analyzeInput(list);
				Ai.setVisible(true);
			}
		

		});

		JLabel lblNodesAdded = new JLabel("Nodes Added:");		// Create nodes added label
		lblNodesAdded.setBounds(10, 75, 88, 14);				// Give the label size
		frame.getContentPane().add(lblNodesAdded);				// Add the label to the frame
		textField_3 = new JTextField();							// Create a new text field
		textField_3.setBounds(10, 101, 275, 20);				// Give the field a size
		frame.getContentPane().add(textField_3);				// Add the field to the frame
		textField_3.setColumns(10);								// Set the number of columns
		textField_3.setText("");
		
		JButton btnNewButton_2 = new JButton("Send To File");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileout file = new fileout();
				file.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(437, 173, 129, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Critical Path");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				critPath critpath = new critPath();
				critpath.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(437, 71, 129, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnChangeDuration = new JButton("Change duration");
		btnChangeDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeDuration change = new changeDuration();
				change.setVisible(true);
			}
		});
		btnChangeDuration.setBounds(437, 105, 129, 23);
		frame.getContentPane().add(btnChangeDuration);
			
	}
}
