import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

  private Node head, tail;

  private class Node {

    Item value;
    Node next;
  }

  public Deque() {
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    int n = 0;
    Node current = head;

    while (current != null) {
      current = current.next;
      n++;
    }
    return n;
  }
  
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    Node oldHead = head;
    head = new Node();
    head.value = item;

    head.next = oldHead;

    if (tail == null) {
      tail = head;
    }
  }

  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }

    Node oldTail = tail;
    tail = new Node();
    tail.value = item;
    tail.next = null;

    if (isEmpty()) {
      head = tail;
    } else {
      oldTail.next = tail;
    }
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }

    Item removedItem = head.value;

    if (head.next == null) {
      head = null;
      tail = null;
    } else {
      head = head.next;
    }

    return removedItem;
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }

    Node current = head;
    while (current.next != tail) {
      current = current.next;
    }

    Item removedItem = tail.value;
    tail = current;
    tail.next = null;

    if (isEmpty()) {
      head = tail;
    }

    return removedItem;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {

    Node current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Node oldCurrent = current;
      current = current.next;
      return oldCurrent.value;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();
    deque.addFirst(1);
    deque.removeFirst();
    deque.addFirst(3);
    deque.removeFirst();
    deque.addFirst(5);
    deque.addFirst(6);
    deque.removeFirst();
    deque.removeFirst();
    deque.addFirst(9);
    deque.removeFirst();
    StdOut.println(deque.isEmpty());
  }
}
