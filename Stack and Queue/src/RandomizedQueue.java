import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Node head, tail;

  private class Node {

    Item value;
    Node next;
  }

  // construct an empty randomized queue
  public RandomizedQueue() {
    this.head = null;
    this.tail = null;
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return head == null;
  }

  // return the number of items on the randomized queue
  public int size() {
    int n = 0;
    Node current = head;
    while (current != null) {
      current = current.next;
      n++;
    }

    return n;
  }

  // add the item
  public void enqueue(Item item) {
    Node newNode = new Node();
    newNode.value = item;
    newNode.next = null;

    if (isEmpty()) {
      head = newNode;
    } else {
      Node oldTail = tail;
      oldTail.next = newNode;
    }

    tail = newNode;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }

    Item dequeuedItem = head.value;
    head = head.next;

    if (isEmpty()) {
      head = tail;
    }

    return dequeuedItem;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    int randomIndex = StdRandom.uniformInt(0, size() - 1);
    Node current = head;
    int n = 0;

    while(n <= randomIndex){
      current = current.next;
      n++;
    }

    return current.value;
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  public void print() {
    Iterator<Item> queueIterator = iterator();

    while (queueIterator.hasNext()) {
      Item value = queueIterator.next();
      StdOut.print(value.toString() + " - ");
    }
    StdOut.println("");
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

  // unit testing (required)
  public static void main(String[] args) {
    RandomizedQueue<Integer> queue = new RandomizedQueue<>();

    for (int i = 1; i <= StdRandom.uniformInt(1, 100); i++) {
      queue.enqueue(i);
    }

    queue.print();
    StdOut.println(queue.sample());
  }
}
