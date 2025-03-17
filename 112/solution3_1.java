/** いただいたコメントを元にした解法 targetSumから現在のNodeの値を引いていくのではなく、新しく引数としてsumを渡していく方針 また、変数名もnodeとした。 */
public class solution3_1 {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return hasPathSumHelper(root, targetSum, 0);
  }

  public boolean hasPathSumHelper(TreeNode node, int targetSum, int sum) {
    if (node == null) {
      return false;
    }
    int currentSum = sum + node.val;
    if (currentSum == targetSum && (node.left == null && node.right == null)) {
      return true;
    }
    return hasPathSumHelper(node.left, targetSum, currentSum)
        || hasPathSumHelper(node.right, targetSum, currentSum);
  }
}
