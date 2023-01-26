import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k;
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        try {
            k = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException nfe) {
            System.out.println("The first argument must be an integer.");
            return;
        }

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            rq.enqueue(word);
        }

        Iterator<String> it = rq.iterator();

        for (int i = 0; i < k; i++) {
            System.out.println(it.next());
        }
    }
}