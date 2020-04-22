public class Factorial {
	public static int factorialWithRecursion(int n) {
		if(n == 1) {
			return 1;
		}
		return n * factorialWithRecursion(n - 1);
	}
	public static int factorialWithoutRecursion(int n) {
		int num = 1;
		for(int i = 1; i <= n; ++i) {
			num *= i;
		}
		return num;
	}
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Not enough parameters!");
			System.exit(-1);
		}

		int number = Integer.parseInt(args[0]);
		System.out.println("With recursion: " + factorialWithRecursion(number));
		System.out.println("Without recursion: " + factorialWithoutRecursion(number));
	}
}
