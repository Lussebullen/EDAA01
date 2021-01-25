package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor p1 = new SingleWordCounter("norge");
		
		TextProcessor m1 = new MultiWordCounter(REGIONS);
		
		ArrayList<TextProcessor> l1 = new ArrayList<TextProcessor>();
		l1.add(p);
		l1.add(p1);
		
		//D7
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (scan.hasNext()) {
			stopwords.add(scan.next());
		}
		TextProcessor r = new GeneralWordCounter(stopwords);
		//D7
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor n : l1) {
				n.process(word);
				m1.process(word);
				r.process(word);
			}
			//p1.process(word);	
			//p.process(word);
		}

		s.close();
		for (TextProcessor n : l1) {
			//n.report();
		}

		//m1.report();
		//p.report();
		//p1.report();
		
		r.report();
	}
}