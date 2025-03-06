import javax.swing.tree.TreeNode;

/**
 * 自力解法。5分ほどでAC 時間計算量O(n) n:要素数、空間計算量O(logn)
 * 解法としては、左右の木を見て最小の高さを再帰をつかって返していく。左だけ、右だけの木があるケースを考慮して、nullの場合はintの最大値を返すようにする。
 * helper関数の命名が微妙だと思った。
 */
public class solution1_1 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return minDepth_helper(root);
  }

  private int minDepth_helper(TreeNode node) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }
    int leftMinDepth = minDepth_helper(node.left);
    int rightMinDepth = minDepth_helper(node.right);
    if (leftMinDepth == Integer.MAX_VALUE && rightMinDepth == Integer.MAX_VALUE) {
      return 1;
    }
    return Math.min(leftMinDepth, rightMinDepth) + 1;
  }
}
