//? Define the princeton algs4.jar in classpath
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
  public static void main(String[] args) {
    //Counting index for bernoulli algorithm
    int index = 0;

    //Global-scoped champion
    String champion = "";

    //Keeps iterating until the next StdIn reading / scan is empty
    while (!StdIn.isEmpty()) {

      //The current scanned word (contender)
      String word = StdIn.readString();
      
      //bernoulli algorithms result (currentIndex + 1.0 (from the initial champion))
      boolean accept = StdRandom.bernoulli(1 / (index + 1.0));
      if (accept) {
        champion = word;
      }

      //increment
      index++;
    }

    //print out the surviving champion
    StdOut.println(champion);
  }
}