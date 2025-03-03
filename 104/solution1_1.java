/**
 * 自力解法 2分ほどでAC 時間計算量O(2^n) n:木の深さ、空間計算量O(n) BFS,DFSどちらでもできるが木が深くなるとDFSのがメモリ的には効率的になると思った。
 * 解き方としては、単純に右左の木を順番に見ていき、現在がnullだったら0を返し、左右大きい方を返していけばOK
 */
public class solution1 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMaxDepth = maxDepth(root.left);
    int rightMaxDepth = maxDepth(root.right);
    return Math.max(leftMaxDepth, rightMaxDepth) + 1;
  }
}
