public class QuickFind {
  private int[] id;

  //? The initialization took O(n)
  public QuickFind(int length) {
    id = new int[length];
    for (int i = 0; i < length; i++) {
      id[i] = i;
    }
  }

  //? The find method took O(1)
  // Two nodes are connected if their value is the same
  public boolean isConnected(int p, int q) {
    // Here, p and q are the index (node), and id[] contains its value
    return id[p] == id[q];
  }

  //? The unite method took O(n), but O(n^2) array accesses
  //This method alter all id[] members which value equals to id[p] to id[q]
  public void unite(int p, int q){
    for(int i = 0; i < id.length; i++){
      if(id[i] == id[p]){
        id[i] = id[q];
      }
    }
  }
}
