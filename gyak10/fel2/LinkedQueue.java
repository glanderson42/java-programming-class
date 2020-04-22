import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T>, Iterable<T> {
  private class Node<T> {
    T item;
    Node<T> next;

    Node(T item) {
      this.item = item;
      this.next = null;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  
  public LinkedQueue() {
    head = null;
    tail = null;
  }

  public boolean empty() {
    return head == null;
  }

  public void enqueue(T item) {
    if(empty()) {
      head = new Node<T>(item);
      tail = head;
      return;
    }

    Node<T> oldTail = tail;
    tail = new Node<T>(item);
    oldTail.next = tail;
  }

  public T dequeue() {
    if(empty()) {
      throw new NoSuchElementException("Empty queue!");
    }

    Node<T> oldHead = head;
    head = oldHead.next;
    return oldHead.item;
  }

  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {
    Node<T> i;

    public ListIterator() {
      i = head;
    }

    public boolean hasNext() {
      return i != null;
    }

    public T next() {
      if(!hasNext()) {
        throw new NoSuchElementException("No next element!");
      }

      T nextElem = i.item;
      i = i.next;
      return nextElem;
    }
  }

  public static void main(String[] args) {
    LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
    System.out.println("Empty?" + linkedQueue.empty());
    linkedQueue.enqueue(1);
    System.out.println("Empty?" + linkedQueue.empty());
    System.out.println("Dequeued: " + linkedQueue.dequeue());
    System.out.println("Empty?" + linkedQueue.empty());

    for(int i = 0; i < 10; ++i) {
      linkedQueue.enqueue(i);
    }

    for(int i : linkedQueue) {
      System.out.println(i);
    }

    linkedQueue.forEach(i -> {
      if(i % 2 == 0) {
        System.out.println(i);
      }
    });
  }
}