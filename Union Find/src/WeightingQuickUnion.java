final class TrackedRoot {
  final int height;
  final int root;

  public TrackedRoot(int height, int root) {
    this.height = height;
    this.root = root;
  }

  public int getHeight() {
    return this.height;
  }

  public int getRoot() {
    return this.root;
  }
}

public class WeightingQuickUnion {
  public int[] id;

  public WeightingQuickUnion(int length) {
    id = new int[length];
    for (int i = 0; i < length; i++) {
      id[i] = i;
    }
  }

  public TrackedRoot root(int i) {
    int height = 0;
    while (i != id[i]) {
      i = id[i];
      height++;
    }

    return new TrackedRoot(height, i);
  }

  public boolean isConnected(int p, int q){
    final TrackedRoot rootP = root(p);
    final TrackedRoot rootQ = root(q);
    return rootP.getRoot() == rootQ.getRoot();
  }

  public void unite(int p, int q){
    final TrackedRoot rootP = root(p);
    final TrackedRoot rootQ = root(q);

    if(rootP.getHeight() > rootQ.getHeight()){
      id[rootQ.getRoot()] = rootP.getRoot(); //altering Q's root to P's root since Q's tree is smaller
    } else {
      id[rootP.getRoot()] = rootQ.getRoot();
    }
  }
}
