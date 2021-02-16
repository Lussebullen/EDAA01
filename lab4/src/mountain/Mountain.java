package mountain;
import java.awt.Point;
import fractal.*;
import static java.lang.Math.*;

public class Mountain extends Fractal {
	private int length;
	private Point a;
	private Point b;
	private Point c;
	
	public Mountain(int length, Point a, Point b, Point c) {
		super();
		this.length = length;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Mountain fractal";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		// TODO Auto-generated method stub	
		drawTriangle(turtle, a, b, c, order);
			
		}
		
	private void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c, int order) {
		drawLine(turtle, a,b);
		drawLine(turtle, b,c);
		drawLine(turtle, a, c);
		if (order!=0) {
			Point pab = new Point((int)((a.getX()+b.getX())/2),(int)((a.getY()+b.getY())/2));
			Point pbc = new Point((int)((c.getX()+b.getX())/2),(int)((c.getY()+b.getY())/2));
			Point pac = new Point((int)((a.getX()+c.getX())/2),(int)((a.getY()+c.getY())/2));
			drawTriangle(turtle, pab, pbc, pac, order-1);
			drawTriangle(turtle, a, pab, pac, order-1);
			drawTriangle(turtle, b, pbc, pab, order-1);
			drawTriangle(turtle, c, pbc, pac, order-1);
		}
	}
		

	private void drawLine(TurtleGraphics turtle, Point a, Point b) {
		turtle.moveTo(a.getX(),a.getY());
		turtle.forwardTo(b.getX(), b.getY());		
	}

}
