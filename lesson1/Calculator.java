public class Calculator {
	public static void helloWorld() {
		System.out.println("Hello world!");
	}
	public static void main(String[] args) {
		helloWorld();
		int num1;
		int num2;

		if(args.length < 2) {
			System.out.println("Not enough parameters!");
			System.exit(-1);
		}

		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[1]);

		System.out.println("a + b = " + (num1 + num2));
		System.out.println("a - b = " + (num1 - num2));
		System.out.println("a * b = " + (num1 * num2));
		if(num2 != 0) {
			System.out.println("a / b = " + ((double)num1 / num2));
		}	
	}
}
