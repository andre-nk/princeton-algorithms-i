public class LinkedStack {
  private Node head = null; //empty, no reference

  private class Node { //inner class

    String value; //accessor doesn't matter here
    Node next;
  }

  public boolean isEmpty() {
    return head == null;
  }

  //Last In First Out
  public void push(String newValue) {
    Node oldHead = head;
    head = new Node();
    head.value = newValue;
    head.next = oldHead;
  }

  public String pop() {
    Node oldHead = head;
    head = oldHead.next;
    return oldHead.value;
  }
}
