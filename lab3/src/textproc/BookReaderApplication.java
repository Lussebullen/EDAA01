package textproc;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class BookReaderApplication {
	public static void main(String[] args) throws FileNotFoundException {
		
		//D3 setup
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (scan.hasNext()) {
			stopwords.add(scan.next());
		}
		GeneralWordCounter r = new GeneralWordCounter(stopwords);
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			r.process(word);
		}
		
		BookReaderController p = new BookReaderController(r);
		
		//D3 setup done
		
		
		List<Map.Entry<String, Integer>> var = r.getWordList();
		//System.out.print(var.get(100));
		
		//D4
		//SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(var);
		//JList<Map.Entry<String, Integer>> listView = new JList<Map.Entry<String, Integer>>(listModel);
		//JScrollPane scrollPane = new JScrollPane(listView);
		//scrollPane.setPreferredSize(new Dimension(200, 100));
		
		//
		
		
	}

}
