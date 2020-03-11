import java.io.*;

public class Main {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.err.println("Not enough command line arguments");
			System.exit(-1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		System.out.println("Give the text to find!");
		String textToFind = System.console().readLine();
		System.out.println("Given text: " + textToFind);
		
		countAndWrite(inputFile, textToFind, outputFile);
	}
	
	private static void countAndWrite(String inputFile, 
									  String textToFind, 
									  String outputFile) {
		File in = new File(inputFile);
		File out = new File(outputFile);
		
		try(
			BufferedReader reader = new BufferedReader(new FileReader(in));
			PrintWriter writer = new PrintWriter(out)
		) {
			String line;
			int counter = 0;
			while(null != (line = reader.readLine())) {
				if(line.contains(textToFind)) {
					++counter;
				}
			}
			
			writer.println(counter);
		} catch(IOException e) {
			System.err.println("IO Exception occurred.");
		}
	}
}
