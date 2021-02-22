package mountain;
import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal {
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	private HashMap<Side,Point> parts; 
	
	public Mountain(int length, Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		this.parts = new HashMap<Side, Point>();
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Mountain fractal";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		// TODO Auto-generated method stub	
		drawTriangle(turtle, a, b, c, order, dev);
		}

// D3
//	private void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c, int order) {
//		drawLine(turtle, a,b);
//		drawLine(turtle, b,c);
//		drawLine(turtle, a, c);
//		if (order!=0) {
//			Point pab = new Point((int)((a.getX()+b.getX())/2),(int)((a.getY()+b.getY())/2));
//			Point pbc = new Point((int)((c.getX()+b.getX())/2),(int)((c.getY()+b.getY())/2));
//			Point pac = new Point((int)((a.getX()+c.getX())/2),(int)((a.getY()+c.getY())/2));
//			drawTriangle(turtle, pab, pbc, pac, order-1);
//			drawTriangle(turtle, a, pab, pac, order-1);
//			drawTriangle(turtle, b, pbc, pab, order-1);
//			drawTriangle(turtle, c, pbc, pac, order-1);
//		}
//	}

	//D4
	private void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c, int order, double dev) {
		
		if (order==0) {
			drawLine(turtle, a,b);
			drawLine(turtle, b,c);
			drawLine(turtle, a, c);
		}  else {
			Point pab = setMid(a,b,dev);
			Point pbc = setMid(b,c,dev);
			Point pac = setMid(a,c,dev);
						
			drawTriangle(turtle, pab, pbc, pac, order-1, dev/2);
			drawTriangle(turtle, a, pab, pac, order-1, dev/2);
			drawTriangle(turtle, b, pbc, pab, order-1, dev/2);
			drawTriangle(turtle, c, pbc, pac, order-1, dev/2);
		}
	}
	
	private Point setMid(Point a, Point b, double dev) {
		Point pab;
		if (parts.containsKey(new Side(a,b))) {
			pab = parts.remove(new Side(a,b));
			return pab;
		} else {
			pab = new Point((int)((a.getX()+b.getX())/2),(int)((a.getY()+b.getY())/2+RandomUtilities.randFunc(dev)));
			parts.put(new Side(a,b), pab);
			return pab;
		}
	}

	private void drawLine(TurtleGraphics turtle, Point a, Point b) {
		turtle.moveTo(a.getX(),a.getY());
		turtle.forwardTo(b.getX(), b.getY());		
	}
}
