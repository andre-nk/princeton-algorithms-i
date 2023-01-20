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

    head.next = oldHead; //points to the old head or null (if this is the first item)

    if (tail == null) { //only contains one Node
      tail = head; //assign to tail if isEmpty()
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
      oldTail.next = tail; //if isEmpty(), oldTail would be null, which got no `next`
    }
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }

    Item removedItem = head.value;
    head = head.next;

    if (isEmpty()) { //If after removal, the Deque is empty, updates the tail to null
      head = tail;
    }

    return removedItem;
  }

  public Item removeLast() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }

    //traverse to the second last node
    Node current = head;
    while (current.next != tail) { //stop if the next Node is the tail (end)
      current = current.next;
    }

    Item removedItem = tail.value;
    tail = current; //assign the tail to the second last node
    tail.next = null;

    if (isEmpty()) {
      head = tail; //assign null to the head, if it's the last Node
    }

    return removedItem;
  }

  public void print() {
    Iterator<Item> dequeIterator = iterator();

    while (dequeIterator.hasNext()) {
      Item value = dequeIterator.next();
      StdOut.print(value.toString() + " - ");
    }
    StdOut.println("");
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
  }

  public static void main(String[] args) {
    //unit tests
    Deque<Integer> deque = new Deque<>();

    //deque.removeFirst();

    deque.print();
    deque.addFirst(1);
    deque.print();
    deque.addLast(2);
    deque.print();
    deque.addLast(3);
    deque.print();
    deque.addFirst(4);
    deque.print();
    deque.removeFirst();
    deque.print();
    deque.removeLast();
    deque.print();
    StdOut.println(deque.size());
    
    //deque.addFirst(null);
  }
}
