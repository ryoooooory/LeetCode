import javax.swing.tree.TreeNode;

/**
 * 自力解法。 5分くらいでAC 時間計算量O(n) n:全要素数、　空間計算量O(n): 最悪の場合は直線になるので再帰の深さはn、平衡木なら深さは最大でもlogn
 * 思考プロセスとしては、まず最後の要素までいかないと結果がわからないのでDFSが自然かなと思ったのでそれで実装した。あとからBFSでもできそうだなとも思ったので実装する。
 * 途中問題文をしっかりよんでなくて再帰の最初でcurrentSum ==
 * targetSumだけで完了判定をしてしまい、葉であることの判定を忘れていたので問題文をしっかり理解してから取り組むようにしないといけない
 */
public class solution1_1 {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return hasPathSumHelper(root, targetSum, root.val);
  }

  boolean hasPathSumHelper(TreeNode root, int targetSum, int currentSum) {
    if (currentSum == targetSum && root.left == null && root.right == null) {
      return true;
    }
    if (root.left != null && hasPathSumHelper(root.left, targetSum, currentSum + root.left.val)) {
      return true;
    }
    if (root.right != null
        && hasPathSumHelper(root.right, targetSum, currentSum + root.right.val)) {
      return true;
    }
    return false;
  }
}
