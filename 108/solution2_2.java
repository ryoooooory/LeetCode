import java.util.Stack;
import javax.swing.tree.TreeNode;

/**
 * https://github.com/t0hsumi/leetcode/pull/24/files　をみてそういえばDFSStack版もできるなと思い実装した。
 * 体感としてもこういう問題はmiddle, left, rightが一般的かなと思った。
 */
public class solution2_2 {
  public TreeNode sortedArrayToBST(int[] nums) {
    Stack<TreeAndIndices> treeAndIndices = new Stack<>();
    int left = 0;
    int right = nums.length - 1;
    int middle = (left + right) / 2;
    TreeNode root = new TreeNode(nums[middle]);
    treeAndIndices.push(new TreeAndIndices(root, left, right));

    while (!treeAndIndices.isEmpty()) {
      TreeAndIndices current = treeAndIndices.pop();
      left = current.left;
      right = current.right;
      middle = (left + right) / 2;
      if (left < middle) {
        TreeNode leftNode = new TreeNode(nums[(left + (middle - 1)) / 2]);
        current.node.left = leftNode;
        treeAndIndices.push(new TreeAndIndices(leftNode, left, middle - 1));
      }
      if (middle < right) {
        TreeNode rightNode = new TreeNode(nums[(right + (middle + 1)) / 2]);
        current.node.right = rightNode;
        treeAndIndices.push(new TreeAndIndices(rightNode, middle + 1, right));
      }
    }
    return root;
  }
}
