import java.util.Iterator;

public class IterableGenericsLinkedStack<Item> implements Iterable<Item> {

  private Node head = null; //empty, no reference

  private class Node { //inner class

    Item value; //accessor doesn't matter here
    Node next;
  }
  
  public boolean isEmpty() {
    return head == null;
  }

  //Last In First Out
  public void push(Item newValue) {
    Node oldHead = head;
    head = new Node();
    head.value = newValue;
    head.next = oldHead;
  }

  public Item pop() {
    Node oldHead = head;
    head = oldHead.next;
    return oldHead.value;
  }

  public void main(String args[]) {
    IterableGenericsLinkedStack<String> stackOfStrings = new IterableGenericsLinkedStack<>();
    stackOfStrings.push("null");
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item>{
    private Node current = head;

    @Override
    public boolean hasNext() {
      return current != null; //Upon next(), the current could be null (if it's the last Node), thus the next would be null as well
    }

    @Override
    public Item next() {
      Node oldCurrent = current;
      current = oldCurrent.next;
      return oldCurrent.value;
    }
  }
}
