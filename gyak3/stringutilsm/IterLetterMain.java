package stringutilsm;

import stringutils.IterLetter;

public class IterLetterMain {
	public static void main(String[] args) {
		IterLetter itr = new IterLetter("asd");
		itr.printNext();
		itr.printNext();
		itr.restart();
		itr.printNext();
		itr.printNext();
		System.out.println(itr.hasNext());
		itr.printNext();
		System.out.println(itr.hasNext());
		IterLetter itr2 = new IterLetter(null);
	}

}
