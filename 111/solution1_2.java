import javax.swing.tree.TreeNode;

/**
 * 自力解法(solution1の派生)。 AC 時間計算量O(n) n:要素数、空間計算量O(logn)
 * 解法としては、solution1でヘルパー関数にしなくてもいいのではないかとおもい、左右の木の深さを初期値を最大値にして、その後にnullでないなら値を更新するようにした。
 * root==null判定は、本当の根の時しか意味がないのでオーバーヘッドが多少ある。
 */
public class solution1_2 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMinDepth = Integer.MAX_VALUE;
    if (root.left != null) {
      leftMinDepth = minDepth(root.left);
    }
    int rightMinDepth = Integer.MAX_VALUE;
    if (root.right != null) {
      rightMinDepth = minDepth(root.right);
    }
    if (leftMinDepth == Integer.MAX_VALUE && rightMinDepth == Integer.MAX_VALUE) {
      return 1;
    }
    return Math.min(leftMinDepth, rightMinDepth) + 1;
  }
}
