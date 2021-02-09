package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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

public class BookReaderController {
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
		}
	private void createWindow(GeneralWordCounter counter, String title,int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		//D4
		List<Map.Entry<String, Integer>> var = counter.getWordList();
		SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(var);
		JList<Map.Entry<String, Integer>> listView = new JList<Map.Entry<String, Integer>>(listModel);
		JScrollPane scrollPane = new JScrollPane(listView);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		pane.add(scrollPane);	
		//
		
		//D5
		//JButton fbut = new JButton("Frequency");
		//JButton abut = new JButton("Alphabetic");
		
		//JPanel panel = new JPanel();
		//panel.add(fbut);
		//panel.add(abut);
		
		//pane.add(panel, BorderLayout.SOUTH);
		//
		
		//V4
		ButtonGroup group = new ButtonGroup();

		JRadioButton fbut = new JRadioButton("Frequency");
		JRadioButton abut = new JRadioButton("Alphabetic");
		group.add(fbut);
		group.add(abut);
		JPanel panel = new JPanel();
		panel.add(fbut);
		panel.add(abut);
		pane.add(panel, BorderLayout.SOUTH);
		//
		
		//D6
		//vbut.addActionListener(event -> {
		//	System.out.println("test");
		//});
		//
		
		//D7
		fbut.addActionListener(event -> {
			listModel.sort(new WordCountComparator());
		});
		
		abut.addActionListener(event -> {
			listModel.sort(new AlphComparator());
		});
		//
		
		//D8 & V2
		JButton nbut = new JButton("Find:");
		JTextField field = new JTextField("",15);  //empty textfield with width of 15 cols.
		panel.add(nbut);
		panel.add(field);
		nbut.addActionListener(event -> {
			String str = field.getText();
			
			//V1
			str=str.toLowerCase();
			str=str.strip();
			//
			
			int indx = -1;
			for (int i = 0; i <listModel.getSize(); i++) {
				if (listModel.getElementAt(i).getKey().equals(str)) {
					indx = i;
				}
			}
			if (indx>=0) {
				listView.ensureIndexIsVisible(indx);
				listView.setSelectedIndex(indx);
			} else { //V2
				JOptionPane popup = new JOptionPane();
				JOptionPane.showMessageDialog(popup,"The word "+str+" does not occur in the book."); 
			}
		});
		//
        
		
		// pane är en behållarkomponent till vilken de övriga komponenterna(listvy, knappar etc.) ska läggas till.
		frame.pack();
		frame.setVisible(true);
	}
}