/*
 * ・概要
 * solution2まででコメントもらったところも踏まえたもの。
 * Stackを使った解法(solution2_3の改良版)
 *
 */

public class solution3_2 {
  private record NodeInfo(TreeNode node, Integer min, Integer max) {}

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return false;
    }
    Deque<NodeInfo> nodes = new ArrayDeque<>();
    nodes.addFirst(new NodeInfo(root, null, null));

    while (!nodes.isEmpty()) {
      NodeInfo current = nodes.removeFirst();
      if (current.node == null) {
        continue;
      }
      if (current.min != null && current.node.val <= current.min) {
        return false;
      }
      if (current.max != null && current.max <= current.node.val) {
        return false;
      }
      nodes.addFirst(new NodeInfo(current.node.left, current.min, current.node.val));
      nodes.addFirst(new NodeInfo(current.node.right, current.node.val, current.max));
    }
    return true;
  }
}
