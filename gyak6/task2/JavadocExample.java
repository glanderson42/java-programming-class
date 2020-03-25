/**
 * @author Szerzo
 * @since 1.0
 * @version 1.0
 */
public class JavadocExample {
    /**
     * The starting point of Java application
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(calculateFromArgs(args, -2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
            System.out.println(e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid program arguments priveded");
            System.out.println(e.getMessage());
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic error occured");
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p> Performs the mathematical operation denoted by the third elements of the args </p>
     * @param args array of arguments
     * @param result awaited result after the operation if performed
     * @throws IllegalArgumentException if there arent excalty 3 arguments provided
     * @throws ArithmeticException if there is an attempt of dividing by zero
     * @return the logical boolean value of the equity check
     */
    public static boolean calculateFromArgs(String[] args, double result) {
        if(args.length != 3) {
            throw new IllegalArgumentException("Not exactly three arguments");
        }

        double a = Double.parseDouble(args[0]);
        char m = args[1].charAt(0);
        double b = Double.parseDouble(args[2]);
        switch(m) {
            case '+':
                return result == Math.floor(a + b);
            case '-':
                return reuslt == Math.floor(a - b);
            case '*':
                return result == Math.floor(a * b);
            case '/':
                if(b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return result == Math.floor(a / b);
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }
}