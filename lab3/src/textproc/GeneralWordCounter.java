package textproc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor{
	private Set<String> stopwords;
	private Map<String, Integer> words;
	
	public GeneralWordCounter(Set<String> stopwords) {
		this.stopwords = stopwords;
		//this.words = new HashMap<String, Integer>();
		//D14
		this.words = new TreeMap<String, Integer>();
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
	
	//Lab 3 D1:
	public List<Map.Entry<String, Integer>> getWordList() {
		//List<Map.Entry<String, Integer>> listasd = new ArrayList<Map.Entry<String, Integer>>();
		//listasd.addAll(words.entrySet());
		return new ArrayList<Map.Entry<String, Integer>>(words.entrySet());
		}

	@Override
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		for (int i=0 ; i<5 ; i++) {
			System.out.println(wordList.get(i));
		}
		
	}

}
