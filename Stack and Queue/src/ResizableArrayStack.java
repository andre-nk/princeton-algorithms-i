import edu.princeton.cs.algs4.StdOut;

public class ResizableArrayStack{
  private String[] arr;
  private int n = 0;

  public ResizableArrayStack(int capacity){
    arr = new String[capacity];
  }

  public boolean isEmpty(){
    return n == 0;
  }

  public void push(String value){
    if(n == arr.length){
      //Grow
      resize(2 * arr.length);
    }
    arr[n++] = value;
  }

  public void pop(String value){
    if(n == 0){
      StdOut.print("The stack is currently empty. Nothing to pop!");
    }

    arr[n] = null;
    n--;

    //Shrink
    if(n <= (arr.length / 2)){
      resize(arr.length / 2);
    }
  }

  public void resize(int capacity){
    String[] newArray = new String[capacity];
    for(int i = 0; i < n; i++){
      newArray[i] = arr[i];
    }
    arr = newArray;
  }
}