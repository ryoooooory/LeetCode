import javax.swing.tree.TreeNode;

/**
 * LeetCodeの解法を参考にしたもの。
 * DFSでsolution1と似た考え。こちらは、targetSumをひいていき0になるか、計算を再帰した先で行うことでhelper関数とかも不必要になった。こちらのがいいかも
 * https://github.com/hroc135/leetcode/pull/24/filesをみるとtargetSumについての計算でinteger
 * overflowを考えていて、自分もしないといけないと思った。 今回は、最大でも10^3(要素数) * 10^3(値の最大値) =
 * 10^6の範囲でおさまる.intは32bitなので-2^31~2^31-の範囲(≒10^9)なのでoverflowはおこらない
 */
public class solution2_1 {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    int sum = targetSum - root.val;
    if (root.left == null && root.right == null && sum == 0) {
      // return sum == 0とするのもあり
      return true;
    }
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}
