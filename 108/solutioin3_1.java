/** いただいたコメントを元に修正したもの。具体的には変数名のリネーム、重複処理の共通化を行なった。 */
public class solutioin3_1 {
  public TreeNode sortedArrayToBST(int[] nums) {
    Stack<TreeAndIndices> stack = new Stack<>();
    int leftIndex = 0;
    int rightIndex = nums.length - 1;
    int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
    TreeNode root = new TreeNode(nums[middleIndex]);
    stack.push(new TreeAndIndices(root, leftIndex, rightIndex));

    while (!stack.isEmpty()) {
      TreeAndIndices current = stack.pop();
      leftIndex = current.left;
      rightIndex = current.right;
      middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
      current.node.val = nums[middleIndex];
      if (leftIndex < middleIndex) {
        TreeNode leftNode = new TreeNode();
        current.node.left = leftNode;
        stack.push(new TreeAndIndices(leftNode, leftIndex, middleIndex - 1));
      }
      if (middleIndex < rightIndex) {
        TreeNode rightNode = new TreeNode();
        current.node.right = rightNode;
        stack.push(new TreeAndIndices(rightNode, middleIndex + 1, rightIndex));
      }
    }
    return root;
  }

  record TreeAndIndices(TreeNode node, int left, int right) {}
  ;
}
