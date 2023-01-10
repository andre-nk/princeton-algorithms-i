public class QuickUnion {
  public int[] id;

  public QuickUnion(int length) {
    id = new int[length];

    for (int i = 0; i < length; i++) {
      id[i] = i;
    }
  }

  public int root(int i) {
    // The highest root is a child in id[] which got the same index and value
    // So, we will step one level up, from the tree to find the root
    while (i != id[i]) {
      i = id[i];
    }

    return i;
  }

  // isConnected() returns true, if p's root = q's root, where p's parent is id[i]
  // (p is the index)
  public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  // Union method works by updating root(p) VALUE (not index) to root (q)
  public void unite(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);
    id[rootP] = rootQ; //updating the value;
  }
}
