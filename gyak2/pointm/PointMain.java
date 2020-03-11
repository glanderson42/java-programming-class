package pointm;

import java.util.Scanner;

import point.Point;	

public class PointMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Point[] points = new Point[3];
		for(int i = 0; i < 3; ++i) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			points[i] = new Point(x, y);
			System.out.println(points[i].toString());
		}
		
		Point center = Point.centerOfMass(points);
		System.out.println("Center of mass: " + center.toString());
	}
}
