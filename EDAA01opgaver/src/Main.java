import se.lth.cs.pt.window.SimpleWindow;

public class Main {
	public static void main(String[] args) {
		Shape[] theShapes = new Shape[2];
		theShapes[0] = new Square(100, 300, 100);
		theShapes[1] = new Square(400, 200, 100);
		SimpleWindow w = new SimpleWindow(600, 600, "");
		
		for (int i = 0; i < theShapes.length; i++) {
			theShapes[i].move(10, 10);
			}
		
		for (int i = 0; i < theShapes.length; i++) {
			theShapes[i].draw(w);
		}
	}
}