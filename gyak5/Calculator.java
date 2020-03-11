public class Calculator {
	public static void main(String[] args) {
		try {
			if(args.length < 3) {
				throw new IllegalArgumentException("Too few arguments!");
			}
			
			double num1 = Double.parseDouble(args[0]);
			char operation = args[1].charAt(0);
			double num2 = Double.parseDouble(args[2]);
			
			System.out.print("" + num1 + operation + num2 + " = ");
			switch(operation) {
				case '+':
					System.out.println(num1 + num2);
					break;
				case '-':
					System.out.println(num1 - num2);
					break;
				case '*':
					System.out.println(num1 * num2);
					break;
				case '/':
					if(num2 == 0) {
						throw new ArithmeticException("Division by zero!");
					}
					System.out.println(num1 / num2);
					break;
				default:
					throw new ArithmeticException("Unknown operation");
			}
		} catch(NumberFormatException exp) {
			System.out.println("Invalid number format!");
			System.out.println(exp.getMessage());
		} catch(IllegalArgumentException exp) {
			System.out.println("Too few arguments!");
			System.out.println(exp.getMessage());
		} catch(ArithmeticException exp) {
			System.out.println("Arithmetic error!");
			System.out.println(exp.getMessage());
		} 
	}
}
