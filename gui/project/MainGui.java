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
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGui {

	private JFrame frame;
	private JFrame HelpFrame;
	private JFrame AboutFrame;
	private JTextField textField;
	private JTextField txtEnterAnInteger;
	private JTextField textField_2;

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
		
		JButton btnNewButton = new JButton("reset");			// Create reset button
		btnNewButton.addMouseListener(new MouseAdapter() {		// Add mouse click listener to reset button
			public void mouseClicked(MouseEvent arg0) {			// Reset routine
			}
		});
		btnNewButton.setBounds(460, 135, 106, 23);				// Give the button size
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
		btnQuit.setBounds(460, 276, 106, 23);					// Give the button size
		frame.getContentPane().add(btnQuit);					// Add the button to the frame
		
		JButton btnNewButton_1 = new JButton("About");			// Create about button
		btnNewButton_1.addMouseListener(new MouseAdapter() {	// Add mouse click listener to about button
			public void mouseClicked(MouseEvent e) {			// About routine
				aboutpage About = new aboutpage();				// Create aboutpage object
				About.setVisible(true);							// Make the object visible
			}
		});
		btnNewButton_1.setBounds(10, 252, 106, 23);				// Give the button size
		frame.getContentPane().add(btnNewButton_1);				// Add the button to the frame
		
		JButton btnHelp = new JButton("Help");					// Create help button
		btnHelp.addMouseListener(new MouseAdapter() {			// Add mouse click listener to help button
			public void mouseClicked(MouseEvent e) {			// Help routine
				helppage Help = new helppage();					// Create helppage object
				Help.setVisible(true);							// Make the object visible
			}
		});
		btnHelp.setBounds(10, 276, 106, 23);					// Give the button size
		frame.getContentPane().add(btnHelp);					// Add the button to the frame
		
		JButton btnEnterNode = new JButton("Enter node");		// Create enter node button
		btnEnterNode.addMouseListener(new MouseAdapter() {		// Add mouse click listener to enter node button
			public void mouseClicked(MouseEvent e) {			// Enter node routine
				// add logic to enter node here
				
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
				txtEnterAnInteger.setText(null);					// Clear the text field
			}
		});
		btnEnterNode.setBounds(460, 71, 106, 23);					// Give the button size
		frame.getContentPane().add(btnEnterNode);					// Add the button to the frame
		
		JButton btnAnalyze = new JButton("Analyze");				// Create the analyze button
		btnAnalyze.setBounds(460, 101, 106, 23);					// Give the button size
		frame.getContentPane().add(btnAnalyze);						// Add the button to the frame
		
		JLabel lblNodesAdded = new JLabel("Nodes Added:");			// Create nodes added label
		lblNodesAdded.setBounds(10, 75, 88, 14);					// Give the label size
		frame.getContentPane().add(lblNodesAdded);					// Add the label to the frame
	}
}
