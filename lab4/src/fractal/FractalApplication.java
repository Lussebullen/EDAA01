package fractal;

import java.awt.Point;

import koch.Koch;
import mountain.Mountain;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		Point a = new Point(50,50);
		Point b = new Point(100,500);
		Point c = new Point(400,300);
		fractals[1] = new Mountain(300, a, b, c);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
