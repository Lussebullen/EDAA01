package sudokuSolverAssignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
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
		
		//Fill grid
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
		
		//actionlistener
		sbut.addActionListener(event -> {
			int[][] mat = new int[9][9];
			for (int i=0; i<81; i++) {		//Turn string from textfield to integer and store. Add errorhandling for wrong type.
				if (boxes[i].getText().length()>0) {
					mat[i%9][i/9] = Integer.parseInt(boxes[i].getText());
				} else {
					mat[i%9][i/9] = 0;
				}
			}
			//make matrix
			Sudoku entry = new Sudoku();
			entry.setMatrix(mat);
			entry.solve();
			int[][] matout = entry.getMatrix();
			for (int i=0; i<81; i++) {	
				boxes[i].setText(String.valueOf(matout[i%9][i/9]));
			}
		});
		
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
