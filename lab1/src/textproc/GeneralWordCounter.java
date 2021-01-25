package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor{
	private Set<String> stopwords;
	private Map<String, Integer> words;
	
	public GeneralWordCounter(Set<String> stopwords) {
		this.stopwords = stopwords;
		this.words = new HashMap<String, Integer>();
	}
	@Override
	public void process(String w) {
		if (stopwords.contains(w)) {	
		} else if (words.containsKey(w)){
			this.words.put(w, words.get(w)+1);
		} else {
			words.put(w, 1);
		}
		
	}

	@Override
	public void report() {
		for (Map.Entry<String, Integer> n : words.entrySet()) {
			if (n.getValue()>=200) {
				System.out.println(n.getKey() + ": " + n.getValue());
			}
		}
		
	}

}
