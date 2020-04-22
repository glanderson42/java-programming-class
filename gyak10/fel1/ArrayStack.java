import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T>, Iterable<T> {
  private T[] items;
  private int numberOfItems;

  @SuppressWarnings("unchecked")
  public ArrayStack() {
    items = (T[]) new Object[8];
    numberOfItems = 0;
  }

  public boolean empty() {
    return numberOfItems == 0;
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    T[] temp = (T[]) new Object[capacity];
    for(int i = 0; i < numberOfItems; i++) {
      temp[i] = items[i];
    }

    items = temp;
  }

  public void push(T item) {
    if(numberOfItems == items.length) {
      resize(items.length * 2);
    }

    items[numberOfItems++] = item;
  }

  public T pop() {
    if(empty()) {
      throw new NoSuchElementException("Empty stack!");
    }

    T tmp = items[numberOfItems - 1];
    items[numberOfItems--] = null;
    --numberOfItems;
    
    if(numberOfItems > 0 && numberOfItems == (items.length / 4)) {
      resize(items.length / 2);
    }

    return tmp;
  }

  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<T> {
     private int i;
           
     public ReverseArrayIterator() {
        i = numberOfItems - 1;
      }

      public boolean hasNext() {
        return i >= 0;
      }

      public T next() {
        if(!hasNext()) {
          throw new NoSuchElementException("Empty stack!");
        }

        return items[i--];
      }
    }

  public static void main(String[] args) {
    ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
    System.out.println("Empty? " + arrayStack.empty());
    arrayStack.push(1);
    arrayStack.push(2);
    arrayStack.push(3);
    arrayStack.push(4);

    for(Integer i : arrayStack) {
      System.out.println(i);
    }

    /*
    * for(Integer i : arrayStack) {
        func(i);
      }
    */
    arrayStack.forEach(i -> {
      System.out.println(i + 2);
    });
  }
}