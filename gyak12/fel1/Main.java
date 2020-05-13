import java.util.Collections;
import java.util.ArrayList;

class Point implements Comparable<Point> {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point that) {
    int xCompareResult = Integer.compare(this.x, that.x);

    if(xCompareResult == 0) {
      return Integer.compare(this.y, that.y);
    }

    return xCompareResult;
  }

  @Override
  public String toString() {
    return "{ " + this.x + " : " + this.y + " }";
  }
}

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<Integer>();
    array.add(1);
    array.add(5);
    array.add(2);
    System.out.println(array);
    Collections.sort(array);
    System.out.println(array);

    ArrayList<Point> points = new ArrayList<Point>();
    points.add(new Point(1, 2));
    points.add(new Point(4 ,6));
    points.add(new Point(-2, 1));
    points.add(new Point(2, 7));
    points.add(new Point(1, 2));
    points.add(new Point(-2, -1));
    System.out.println(points);
    Collections.sort(points);
    System.out.println(points);
  }
}