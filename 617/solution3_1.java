/**
 * いただいたコメントを元に修正したもの。 具体的には番兵を使った分岐処理の削除、変数名の変更、Stackに追加する構造体の定義を行なった。
 * 番兵については、連結リストでつかったり、ループでも使える場面もあるので条件分岐が大きくなったら番兵で減らせないかを考える癖をつける
 */
public class solution3_1 {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }
    Stack<TreeForMerge> nodesForMerge = new Stack<>();
    TreeNode mergedTree = new TreeNode();
    nodesForMerge.push(new TreeForMerge(mergedTree, root1, root2));
    while (!nodesForMerge.isEmpty()) {
      TreeForMerge nodes = nodesForMerge.pop();
      TreeNode merge = nodes.merge;
      if (nodes.node1 == null && nodes.node2 == null) {
        continue;
      }
      TreeNode node1 = nodes.node1 != null ? nodes.node1 : new TreeNode(0);
      TreeNode node2 = nodes.node2 != null ? nodes.node2 : new TreeNode(0);
      merge.val = node1.val + node2.val;

      if (node1.left != null || node2.left != null) {
        TreeNode leftNode = new TreeNode();
        merge.left = leftNode;
        nodesForMerge.push(new TreeForMerge(leftNode, node1.left, node2.left));
      }
      if (node1.right != null || node2.right != null) {
        TreeNode rightNode = new TreeNode();
        merge.right = rightNode;
        nodesForMerge.push(new TreeForMerge(rightNode, node1.right, node2.right));
      }
    }
    return mergedTree;
  }

  record TreeForMerge(TreeNode merge, TreeNode node1, TreeNode node2) {}
  ;
}
