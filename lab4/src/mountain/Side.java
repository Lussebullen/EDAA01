package mountain;
import java.util.HashSet;

public class Side {
	private Point a;
	private Point b;
	
	public Side(Point a, Point b) {
		this.a=a;
		this.b=b;
	}
	
	@Override
	public int hashCode() {
		return a.hashCode() + b.hashCode();
		}
	
	@Override
	public boolean equals(Object f) {
		
		if (f instanceof Side == false) {
			return false;
		}
		Side g = (Side) f;
		if (g.a.equals(this.a) && g.b.equals(this.b)) {
			return true;
		} else if (g.a.equals(this.b) && g.b.equals(this.a)) {
			return true;
		} else {
			return false;
		}
	}
}
