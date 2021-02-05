package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
		System.out.println(var.get(1000));
		
		
		
	}

}
