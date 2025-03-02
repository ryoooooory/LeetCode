public class solution1 {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> leftEdgeToIndex = new HashMap<Integer, List<Integer>>();
    Map<Integer, List<Integer>> rightEdgeToIndex = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      List<Integer> leftIndexList = leftEdgeToIndex.getOrDefault(edge[0], new ArrayList<>());
      List<Integer> rightIndexList = rightEdgeToIndex.getOrDefault(edge[1], new ArrayList<>());
      leftIndexList.add(i);
      rightIndexList.add(i);
      leftEdgeToIndex.put(edge[0], leftIndexList);
      rightEdgeToIndex.put(edge[1], rightIndexList);
    }

    Set<Integer> visited = new HashSet<>();
    int connectedNodes = 0;
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      visited.add(i);
      connectedNodes++;
      checkConnectedEdge(edges, leftEdgeToIndex, rightEdgeToIndex, visited, i);
    }
    return connectedNodes;
  }

  void checkConnectedEdge(
      int[][] edges,
      Map<Integer, List<Integer>> leftEdgeToIndex,
      Map<Integer, List<Integer>> rightEdgeToIndex,
      Set<Integer> visited,
      int currentVal) {
    List<Integer> leftIndex = leftEdgeToIndex.getOrDefault(currentVal, new ArrayList());
    List<Integer> rightIndex = rightEdgeToIndex.getOrDefault(currentVal, new ArrayList());
    visited.add(currentVal);
    for (int index : leftIndex) {
      int connectedVal = edges[index][1];
      if (visited.contains(connectedVal)) {
        continue;
      }
      checkConnectedEdge(edges, leftEdgeToIndex, rightEdgeToIndex, visited, connectedVal);
    }
    for (int index : rightIndex) {
      int connectedVal = edges[index][0];
      if (visited.contains(connectedVal)) {
        continue;
      }
      visited.add(connectedVal);
      checkConnectedEdge(edges, leftEdgeToIndex, rightEdgeToIndex, visited, connectedVal);
    }
  }
}
