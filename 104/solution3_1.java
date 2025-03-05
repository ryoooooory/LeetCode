/** いただいたコメントを元に修正したもの。 具体的にはrecordを使ったstackでのDFS */
public class solution3_1 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Stack<TreeInfo> treeInfo = new Stack<>();
    treeInfo.push(new TreeInfo(root, 1));
    int maxDepth = 1;
    while (!treeInfo.isEmpty()) {
      TreeInfo current = treeInfo.pop();
      maxDepth = Math.max(maxDepth, current.depth);
      if (current.node.left != null) {
        treeInfo.push(new TreeInfo(current.node.left, current.depth + 1));
      }
      if (current.node.right != null) {
        treeInfo.push(new TreeInfo(current.node.right, current.depth + 1));
      }
    }
    return maxDepth;
  }

  record TreeInfo(TreeNode node, int depth) {}
  ;
}
