import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private int size = 0;
  private Item[] items;

  private class RandomizedQueueIterator implements Iterator<Item> {

    private int[] randomIndexes = new int[size];
    private int totalSelected = 0;

    public RandomizedQueueIterator() {
      for (int i = 0; i < size; i++) {
        randomIndexes[i] = i;
      }
      StdRandom.shuffle(randomIndexes);
    }

    public boolean hasNext() {
      return totalSelected < size && size != 0;
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("There are no more items to return");
      }
      int selectedIndex = randomIndexes[totalSelected++];
      return items[selectedIndex];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  public RandomizedQueue() {
    items = (Item[]) new Object[2];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(Item item) {
    if (item == null) throw new IllegalArgumentException(
      "item must not be null"
    );
    if (size == items.length) resize(2 * items.length);
    if (size == 0) {
      items[size++] = item;
      return;
    }
    items[size++] = item;
  }

  public Item dequeue() {
    if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty");
    if (size > 0 && size == items.length / 4) resize(items.length / 2);

    int selectedIndex = StdRandom.uniformInt(size);
    Item item = items[selectedIndex];
    items[selectedIndex] = items[--size];
    items[size] = null;
    return item;
  }

  public Item sample() {
    if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty");
    return items[StdRandom.uniformInt(size)];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private void resize(int newCapacity) {
    Item[] copy = (Item[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) copy[i] = items[i];
    items = copy;
  }

  public static void main(String[] args) {
    RandomizedQueue<Integer> queue = new RandomizedQueue<>();
    queue.size(); // ==> 0
    queue.isEmpty(); // ==> true
    queue.enqueue(506);
    queue.size(); // ==> 1
    queue.isEmpty(); // ==> false
    queue.dequeue(); // ==> 506
    StdOut.println(queue.isEmpty());// ==> false
  }
}
