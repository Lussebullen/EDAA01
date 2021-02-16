package mountain;
import java.awt.Point;
import fractal.*;
import static java.lang.Math.*;

public class Mountain extends Fractal {
	private int length;
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	
	public Mountain(int length, Point a, Point b, Point c, double dev) {
		super();
		this.length = length;
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
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
		} else if (order==1) {
			Point pab = new Point((int)((a.getX()+b.getX())/2),(int)((a.getY()+b.getY())/2+RandomUtilities.randFunc(dev)));
			Point pbc = new Point((int)((c.getX()+b.getX())/2),(int)((c.getY()+b.getY())/2+RandomUtilities.randFunc(dev)));
			Point pac = new Point((int)((a.getX()+c.getX())/2),(int)((a.getY()+c.getY())/2+RandomUtilities.randFunc(dev)));
			drawLine(turtle,a,pab);
			drawLine(turtle,pab,b);
			drawLine(turtle,b,pbc);
			drawLine(turtle,pbc,c);
			drawLine(turtle,c,pac);
			drawLine(turtle,pac,a);
			drawLine(turtle,pab,pbc);
			drawLine(turtle,pab,pac);
			drawLine(turtle,pbc,pac);
		} else {
			Point pab = new Point((int)((a.getX()+b.getX())/2),(int)((a.getY()+b.getY())/2+RandomUtilities.randFunc(dev)));
			Point pbc = new Point((int)((c.getX()+b.getX())/2),(int)((c.getY()+b.getY())/2+RandomUtilities.randFunc(dev)));
			Point pac = new Point((int)((a.getX()+c.getX())/2),(int)((a.getY()+c.getY())/2+RandomUtilities.randFunc(dev)));
			
			drawTriangle(turtle, pab, pbc, pac, order-1, dev/2);
			drawTriangle(turtle, a, pab, pac, order-1, dev/2);
			drawTriangle(turtle, b, pbc, pab, order-1, dev/2);
			drawTriangle(turtle, c, pbc, pac, order-1, dev/2);
		}
	}
		

	private void drawLine(TurtleGraphics turtle, Point a, Point b) {
		turtle.moveTo(a.getX(),a.getY());
		turtle.forwardTo(b.getX(), b.getY());		
	}

}
