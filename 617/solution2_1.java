/**
 * LeetCodeの解法を参考にしたもの。 計算量はsolution1_1と変わりなし。
 * 対象がnullだったら別の方を返すだけでよく、両方ある時は値を合算して、再帰するだけでいいというものだった。自力解法のときに再帰した時にどうなるかをイメージが甘かったなと気付かされた。
 */
public class solution2_1 {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    TreeNode mergedTree = new TreeNode(root1.val + root2.val);
    mergedTree.left = mergeTrees(root1.left, root2.left);
    mergedTree.right = mergeTrees(root1.right, root2.right);
    return mergedTree;
  }
}
