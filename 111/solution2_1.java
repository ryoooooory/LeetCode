/** */
public class solution2_1 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int depth = 1;
    while (!nodes.isEmpty()) {
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
    return depth;
  }
}
