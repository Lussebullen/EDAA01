package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;

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
		JButton vbut = new JButton("Alphabetic");
		JButton hbut = new JButton("Frequency");
		
		JPanel panel = new JPanel();
		panel.add(hbut);
		panel.add(vbut);
		
		pane.add(panel, BorderLayout.SOUTH);
		//
		
		// pane är en behållarkomponent till vilken de övriga komponenterna(listvy, knappar etc.) ska läggas till.
		frame.pack();
		frame.setVisible(true);
	}
}