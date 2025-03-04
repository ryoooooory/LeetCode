/**
 * solution2_1についてhttps://github.com/colorbox/leetcode/pull/37/filesのコメントにあった、入力の木と出力の木で共有されている場合があることに備えて、すべて新しい木を生成しなおしたもの
 * *
 */
public class solution2_2 {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    } else if (root1 == null) {
      return makeOneChildTree(root2);
    } else if (root2 == null) {
      return makeOneChildTree(root1);
    }
    TreeNode mergedTree = new TreeNode(root1.val + root2.val);
    mergedTree.left = mergeTrees(root1.left, root2.left);
    mergedTree.right = mergeTrees(root1.right, root2.right);
    return mergedTree;
  }

  private TreeNode makeOneChildTree(TreeNode child) {
    TreeNode tree = new TreeNode(child.val);
    tree.left = mergeTrees(null, child.left);
    tree.right = mergeTrees(null, child.right);
    return tree;
  }
}
