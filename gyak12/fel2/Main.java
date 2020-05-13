import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

class ExtendedString 
  implements 
    Comparable<ExtendedString>, 
    Iterable<Character> {

  private String data;

  public ExtendedString(String data) {
    this.data = data;
  }

  @Override
  public Iterator<Character> iterator() {
    return new ExtendedStringIterator(this.data);
  }

  @Override
  public int compareTo(ExtendedString that) {
    return this.data.length() - that.data.length();
  }

  @Override
  public String toString() {
    return this.data;
  }

}

class ExtendedStringIterator implements Iterator<Character> {
  private String stringToIterate;
  private int counter;

  public ExtendedStringIterator(String stringToIterate) {
    this.stringToIterate = stringToIterate;
    this.counter = 0;
  }

  @Override
  public boolean hasNext() {
    return this.counter < this.stringToIterate.length();
  }

  @Override
  public Character next() {
    return this.stringToIterate.charAt(this.counter++);
  }

  @Override
  public void remove() {
    this.counter++;
  }
}

public class Main {
  public static void main(String[] args) {
    ExtendedString tmp1 = new ExtendedString("Hello ");
    ExtendedString tmp2 = new ExtendedString("World!");

    System.out.println("tmp1.compareTo(tmp2): " + tmp1.compareTo(tmp2));
    System.out.println("tmp2.compareTo(tmp1): " + tmp2.compareTo(tmp1));

    Iterator<Character> it = tmp1.iterator();

    while(it.hasNext()) {
      char ch = it.next();
      System.out.println("ch: " + ch);
    }

    it = tmp1.iterator();
    if(it.hasNext()) {
      it.remove();
    }

    while(it.hasNext()) {
      char ch = it.next();
      System.out.println("ch: " + ch);
    }

    ArrayList<ExtendedString> list = new ArrayList<ExtendedString>();
    list.add(new ExtendedString("This is a sentence"));
    list.add(tmp1);
    list.add(tmp2);
    list.add(new ExtendedString("java"));
    list.add(new ExtendedString("c"));
    list.add(new ExtendedString("cpp"));
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
  }
}