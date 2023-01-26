import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Sorting {

  String[] array = {
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
  };

  public Sorting() {}

  public void shuffle() {
    for (int i = 0; i < array.length; i++) {
      int r = StdRandom.uniformInt(0, i + 1);
      exch(array, i, r);
    }
  }

  public void print() {
    for (int i = 0; i < array.length; i++) {
      StdOut.print(array[i]);
    }
    StdOut.println();
  }

  private void exch(String[] array, int indexSrc, int indexTarget) {
    String a = array[indexSrc];
    array[indexSrc] = array[indexTarget];
    array[indexTarget] = a;
  }

  public static void main(String[] args) {
    Sorting sortObject = new Sorting();

    for (int i = 0; i < 10; i++) {
      sortObject.shuffle();
      sortObject.print();
    }
  }
}
