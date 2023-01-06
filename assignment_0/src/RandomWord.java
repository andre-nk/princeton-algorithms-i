import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
  public static void main(String[] args) {
    // while reading is not empty, keep going and increment
    // in each iteration, run the bernoulli algorithm
    int count = 0;
    String champion = "";

    while (!(StdIn.readLine().isEmpty())) {
      count++;
      String challenger = StdIn.readLine();

      if(StdRandom.bernoulli(1/count)){
        champion = challenger;
      }
    }

    StdOut.print(champion);
  }
}
