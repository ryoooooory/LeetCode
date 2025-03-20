/**
 * LeetCodeの解法を参考にしたもの。 inorederで探索した場合には、BSTの定義的に1個前のnodeの値より大きければいいので、1個前の値をクラスプロパティとして持たせる。
 * 個人的には一番直感的（solution1_1でBSTは結局ソートされている配列になおせることを考えるとそらそうかという気持ち）
 */
public class solution2_2 {

  private Integer prev;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }
    if (prev != null && root.val <= prev) {
      return false;
    }
    prev = root.val;
    return isValidBST(root.right);
  }
}
