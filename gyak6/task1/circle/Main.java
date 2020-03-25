package circle;

import java.io.IOException;
import java.io.FileNotFoundException;

import circle.utils.Point;

public class Main {
    public static void main(String[] args) {
        Point center = new Point();
        Circle c1 = new Circle(center, 10, null);
        System.out.println(c1);

        c1.enlarge(3);
        System.out.println(c1);

        Circle c2 = null;

        try {
            c2 = Circle.readFromFile("in.txt");
        } catch (FileNotFoundException exp) {
            System.err.println("Error: Unable to access file, " + exp.getMessage());
        } catch(IOException exp) {
            System.err.println("Error: IOException occured, " + exp.getMessage());
        }

        System.out.println(c2);
    }
}