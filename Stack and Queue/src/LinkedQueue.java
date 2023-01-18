public class LinkedQueue {
  private Node head, tail; //last Node is used to reduce linear time of iteration

  private class Node{
    String value;
    Node next;
  }

  public boolean isEmpty(){
    return head == null;
  }

  //FIFO (First In First Out)
  //add to last
  public void enqueue(String newValue){
    Node oldTail = tail;
    tail = new Node();
    tail.value = newValue;
    tail.next = null;
    if(isEmpty()){
      head = tail;
    } else {
      oldTail.next = tail;
    }
  }

  //remove first
  public String dequeue(){
    Node oldHead = head;
    head = oldHead.next;
    return oldHead.value;
  }
}
