import java.util.Set;

public class solution2_3 {
  class UnionFind {
    int[] parent;
    int[] rank; // 高さ

    UnionFind(int numberOfElement) {
      parent = new int[numberOfElement];
      rank = new int[numberOfElement];
      for (int i = 0; i < numberOfElement; i++) {
        parent[i] = i;
      }
    }

    public int root(int element) {
      if (element == parent[element]) {
        return element;
      } else {
        return parent[element] = root(parent[element]); // 経路圧縮
      }
    }

    public void union(int e1, int e2) {
      int r1 = root(e1);
      int r2 = root(e2);

      // union by rankを用いた効率化
      if (r1 == r2) {
        return;
      } else if (rank[r1] < rank[r2]) {
        parent[r1] = r2;
      } else if (rank[r2] < rank[r1]) {
        parent[r2] = r1;
      } else {
        parent[r1] = r2;
        rank[r2]++;
      }
    }
  }

  public int countComponents(int n, int[][] edges) {
    UnionFind connectedGraph = new UnionFind(n);
    for (int[] edge : edges) {
      connectedGraph.union(edge[0], edge[1]);
    }
    Set<Integer> parent = new HashSet<>();
    for (int node = 0; node < n; node++) {
      int root = connectedGraph.root(node);
      if (!parent.contains(root)) {
        parent.add(root);
      }
    }
    return parent.size();
  }
}
