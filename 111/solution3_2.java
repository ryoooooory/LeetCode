/**
 * いただいたコメントを元に修正したもの。 BFSでの解法について、問題要件からwhileの中でreturnすることが決まっているので無限ループにして、whileの外でのreturnをなくしたもの
 */
public class solution3_2 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int depth = 1;
    while (true) {
      Queue<TreeNode> nextDepthNodes = new ArrayDeque<>();
      while (!nodes.isEmpty()) {
        TreeNode current = nodes.poll();
        if (current.left == null && current.right == null) {
          return depth;
        }
        if (current.left != null) {
          nextDepthNodes.offer(current.left);
        }
        if (current.right != null) {
          nextDepthNodes.offer(current.right);
        }
      }
      nodes = nextDepthNodes;
      depth++;
    }
  }
}
