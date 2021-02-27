package sudokuSolverAssignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUI {
	public GUI() {
		SwingUtilities.invokeLater(() -> createWindow("SudokuSolver", 500, 550));
	}
	private void createWindow(String title, int heigth, int width) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		//Panel for sudokuinput grid
		JPanel gridpanel = new JPanel();
		gridpanel.setLayout(new GridLayout(0, 9, 3, 3));
		pane.add(gridpanel, BorderLayout.NORTH);
		
		//panel for buttons below
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(0, 2));
		pane.add(buttonpanel);
		pane.add(buttonpanel, BorderLayout.SOUTH);
		
		//Fill grid, and color 3x3 sections.
		JTextField[] boxes = new JTextField[81];
		for (int i=0; i<81; i++) {
			boxes[i] = new JTextField( "" );
			boxes[i].setHorizontalAlignment(JTextField.CENTER); //centers text
			boxes[i].setPreferredSize( new Dimension( 200, 50 ) );   //makes textfields square
			if ((i+3)%9<6 && i<27 || (i+3)%9<6 && i>= 54 || i>=27 && i<54 && 2<i%9 && i%9<6) { //grid coloring
				boxes[i].setBackground(Color.orange);
			}
			gridpanel.add(boxes[i]);
		}
		
		//buttons
		JButton sbut = new JButton("Solve");
		JButton cbut = new JButton("Clear");
		buttonpanel.add(sbut);
		buttonpanel.add(cbut);
		
		//actionlistener for solve
		sbut.addActionListener(event -> {
			int[][] mat = new int[9][9];	//matrix
			for (int i=0; i<81; i++) {		//Turn string from textfield to integer and store. Add errorhandling for wrong type.
				try {
					if (boxes[i].getText().length()>0) {  //checks integer 1-9
						int a = Integer.parseInt(boxes[i].getText());
						if (a<10 && a>0) {
							mat[i%9][i/9] = a;
						} else { //if wrong integer 
							JOptionPane.showMessageDialog(frame, "Invalid integer, input must be an integer in [1,9]");
							return; //stops code
						}
					} else { //if empty textfield
						mat[i%9][i/9] = 0;
					}
					
				} catch(Exception e) { //if non integer input
					JOptionPane.showMessageDialog(frame, "Invalid input, Input must be an integer in [1,9]");
					return; //stops code
				}
			}
			//make matrix and solve
			Sudoku entry = new Sudoku();
			entry.setMatrix(mat);
			boolean status = entry.solve();
			//If else is done in case a valid sudoku entry is actually not solveable, easier to leave it here just in case.
			if (status) { //show solved matrix in GUI
				int[][] matout = entry.getMatrix();
				for (int i=0; i<81; i++) {	
					boxes[i].setText(String.valueOf(matout[i%9][i/9]));
				}
			} else { //If unsolvable
				JOptionPane.showMessageDialog(frame, "Sudoku has no solution, please check that numbers are unique in each row, column and quadrant.");
			}
		});
		
		//Clears the grid when clear button is pressed.
		cbut.addActionListener(event -> {
			for (int i=0; i<81; i++) {	
				boxes[i].setText("");
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(heigth,width);
	}
}
