// 自力解法。10分くらいでAC
// 時間計算量: O(n) n:２つの木の要素数、空間計算量: O(n)
// 左の木と右の木について処理はほぼ一緒なので関数化したが、left, rightによって思いつかなかった。
public class solution1_1 {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }
    int r1Value = root1 != null ? root1.val : 0;
    int l1Value = root2 != null ? root2.val : 0;
    TreeNode mergedNode = new TreeNode(r1Value + l1Value);

    if (root1 == null) {
      mergedNode.left = root2.left;
    } else if (root2 == null) {
      mergedNode.left = root1.left;
    } else {
      mergedNode.left = mergeTrees(root1.left, root2.left);
    }
    if (root1 == null) {
      mergedNode.right = root2.right;
    } else if (root2 == null) {
      mergedNode.right = root1.right;
    } else {
      mergedNode.right = mergeTrees(root1.right, root2.right);
    }
    return mergedNode;
  }
}
