public class solution2_1 {
  public int countComponents(int n, int[][] edges) {
    int numOfConnectedComponents = 0;
    boolean[] visited = new boolean[n];
    List<Integer>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < edges.length; i++) {
      graph[edges[i][0]].add(edges[i][1]);
      graph[edges[i][1]].add(edges[i][0]);
    }

    for (int node = 0; node < n; node++) {
      if (visited[node]) {
        continue;
      }
      numOfConnectedComponents++;
      checkConnectedNode(edges, graph, visited, node);
    }
    return numOfConnectedComponents;
  }

  void checkConnectedNode(int[][] edges, List<Integer>[] graph, boolean[] visited, int node) {
    visited[node] = true;
    for (int i = 0; i < graph[node].size(); i++) {
      int connectedNode = graph[node].get(i);
      if (visited[connectedNode]) {
        continue;
      }
      checkConnectedNode(edges, graph, visited, connectedNode);
    }
  }
}
