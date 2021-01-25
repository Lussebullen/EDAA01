package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{
	private Map<String, Integer> words;
	
	public MultiWordCounter(String[] words) {
		Map<String, Integer> con = new HashMap<String, Integer>();
		for (String n : words) {
			con.put(n, 0);
		}
		this.words = con;
	}
	@Override
	public void process(String w) {
		// TODO Auto-generated method stub
		for (Map.Entry<String, Integer> n : words.entrySet()) {
			if (w.equals(n.getKey())) {
				this.words.put(n.getKey(), n.getValue()+1);
			}
		}
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		for (Map.Entry<String, Integer> n : words.entrySet()) {
			System.out.println(n.getKey() + ": " + n.getValue());	
		}
	}

}
