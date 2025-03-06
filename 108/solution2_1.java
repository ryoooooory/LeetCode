import javax.swing.tree.TreeNode;

/**
 * https://github.com/colorbox/leetcode/pull/38/filesのコメントをみて変数名をリネームしたもの。 体感としてもこういう問題はmiddle,
 * left, rightが一般的かなと思った。
 */
public class solution2_1 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
    if (right < left) {
      return null;
    }
    int middle = (left + right) / 2;
    TreeNode node = new TreeNode(nums[middle]);
    node.left = sortedArrayToBSTHelper(nums, left, middle - 1);
    node.right = sortedArrayToBSTHelper(nums, middle + 1, right);
    return node;
  }
}
