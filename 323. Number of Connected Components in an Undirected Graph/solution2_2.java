public class solution2_2 {
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

  private void checkConnectedNode(
      int[][] edges, List<Integer>[] graph, boolean[] visited, int node) {
    visited[node] = true;
    Queue<Integer> connectedNode = new LinkedList<Integer>();
    connectedNode.add(node);
    while (!connectedNode.isEmpty()) {
      int current = connectedNode.poll();
      List<Integer> adjacentNodes = graph[current];
      for (int adjacentNode : adjacentNodes) {
        if (!visited[adjacentNode]) {
          visited[adjacentNode] = true;
          connectedNode.add(adjacentNode);
        }
      }
    }
  }
}
