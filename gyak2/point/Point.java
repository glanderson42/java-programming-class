package point;

public class Point {
	private double x;
	private double y;
	
	public static Point centerOfMass(Point[] points) {
		double avgX = 0;
		double avgY = 0;
		for(int i = 0; i < points.length; ++i) {
			avgX += points[i].getX();
			avgY += points[i].getY(); 
		}
		
		avgX /= points.length;
		avgY /= points.length;
		
		return new Point(avgX, avgY);
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void mirror(double cx, double cy) {
		x = cx - (x - cx);
		y = cy - (y - cy);
	}

	public void mirror(Point p) {
		x = p.getX() - (x - p.getX());
		y = p.getY() - (y - p.getY());
	}
	
	public double distance(Point p) {
		//Math.sqrt()
		//Math.pow(a, b)
		return Math.sqrt((Math.pow((p.getX() -  x), 2) + Math.pow((p.getY() - y), 2)));
	}

	@Override
	public String toString() {
		return "x: " + x + " y: " + y;
	}
}
