package textproc;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class AlphComparator implements Comparator<Map.Entry<String, Integer>> {

	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		if (o1.getKey().compareTo(o2.getKey())>0) {
			return 1;
		} else {
			return -1;
		}
		
	}

}
