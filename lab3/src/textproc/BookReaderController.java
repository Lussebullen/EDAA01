package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		JButton fbut = new JButton("Frequency");
		JButton abut = new JButton("Alphabetic");
		
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
		
		// pane är en behållarkomponent till vilken de övriga komponenterna(listvy, knappar etc.) ska läggas till.
		frame.pack();
		frame.setVisible(true);
	}
}