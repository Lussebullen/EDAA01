package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor n : l1) {
				n.process(word);
				m1.process(word);
			}
			//p1.process(word);	
			//p.process(word);
		}

		s.close();
		for (TextProcessor n : l1) {
			n.report();
		}

		m1.report();
		//p.report();
		//p1.report();
	}
}