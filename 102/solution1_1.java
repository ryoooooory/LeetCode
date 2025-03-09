/**
 * 自力解法。10分ほどでAC 時間計算量: O(n), 空間計算量: O(n) n:全要素数 思考プロセスとしては、各階層のものを順にみていくのでBFSが一番直感的だと思ったのでそれで実装。
 * 階層の区切りにQueueを使った。
 */
public class solution1_1 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> values = new ArrayList<>();
    if (root == null) {
      return values;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    while (!nodes.isEmpty()) {
      Queue<TreeNode> nodesInNextLevel = new ArrayDeque<>();
      List<Integer> valuesInNextLevel = new ArrayList<>();
      while (!nodes.isEmpty()) {
        TreeNode current = nodes.poll();
        valuesInNextLevel.add(current.val);
        if (current.left != null) {
          nodesInNextLevel.offer(current.left);
        }
        if (current.right != null) {
          nodesInNextLevel.offer(current.right);
        }
      }
      values.add(valuesInNextLevel);
      nodes = nodesInNextLevel;
    }
    return values;
  }
}
