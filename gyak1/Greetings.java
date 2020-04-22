public class Greetings {
	public static void main(String[] args) {
		System.out.println("Hello " + args[0] + "!");
		System.console().printf("Hello %s !", args[0]);
	}
}
