import java.util.ArrayList;
import java.util.List;

public class solutions2_4 {
  public int countComponents(int n, int[][] edges) {
    List<Integer>[] adjacentList = new ArrayList[n];
    for (int node = 0; node < n; node++) {
      adjacentList[node] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      adjacentList[edge[0]].add(edge[1]);
      adjacentList[edge[1]].add(edge[0]);
    }
    int numOfConnectedComponents = 0;
    boolean[] visited = new boolean[n];
    for (int node = 0; node < n; node++) {
      if (visited[node]) {
        continue;
      }
      numOfConnectedComponents++;
      visited[node] = true;
      visitAllConnectedNodes(adjacentList, node, visited);
    }
    return numOfConnectedComponents;
  }

  void visitAllConnectedNodes(List<Integer>[] adjacentList, int current, boolean[] visited) {
    for (int adjacent : adjacentList[current]) {
      if (visited[adjacent]) {
        continue;
      }
      visited[adjacent] = true;
      visitAllConnectedNodes(adjacentList, adjacent, visited);
    }
  }
}
