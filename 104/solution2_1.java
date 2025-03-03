/** LeetCodeの解法をみたもの 解法としては、StackをつかったIteration Dfsと同じように探索する */
public class solution2_1 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Stack<TreeNode> nodes = new Stack<>();
    Stack<Integer> depths = new Stack<>();
    nodes.push(root);
    depths.push(1);
    int maxDepth = 0;
    while (!nodes.isEmpty()) {
      TreeNode currentNode = nodes.pop();
      int currentDepth = depths.pop();
      maxDepth = Math.max(maxDepth, currentDepth);
      if (currentNode.left != null) {
        nodes.push(currentNode.left);
        depths.push(currentDepth + 1);
      }
      if (currentNode.right != null) {
        nodes.push(currentNode.right);
        depths.push(currentDepth + 1);
      }
    }
    return maxDepth;
  }
}
