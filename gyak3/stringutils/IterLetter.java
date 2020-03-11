package stringutils;

public class IterLetter {
	private String buffer;
	private int bufferIndex;
	
	public IterLetter(String bffr) {
		if(bffr != null) {
			buffer = new String(bffr);
			bufferIndex = 0;
		} else {
			System.out.println("Param is null!");
		}
	}
	
	public void printNext() {
		System.out.println(buffer.charAt(bufferIndex));
		++bufferIndex;
	}
	
	public void restart() {
		bufferIndex = 0;
	}
	
	public boolean hasNext() {
		return (bufferIndex + 1 <= buffer.length());
	}
}
