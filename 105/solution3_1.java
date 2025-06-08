/*
 * ・概要
 * コメントいただいた部分を改善したもの。
 * 主に変数名についてのリファクタリング。Mapについては、基本格納する情報を両方表した方が良さそう。(ex: valToIndexみたいな)
 *
 * ・計算量
 * 時間計算量O(n), 空間計算量: O(n) n:木の要素数、再帰の深さも最大でn,
 *
 */

public class solution3_1 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderValToIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderValToIndex.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, inorderValToIndex, 0, preorder.length - 1);
  }

  private TreeNode buildTreeHelper(
      int[] preorder,
      int preorederIndex,
      Map<Integer, Integer> inorderValToIndex,
      int left,
      int right) {
    if (right < left) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[preorederIndex]);
    int inorderIndex = inorderValToIndex.get(node.val);
    node.left =
        buildTreeHelper(preorder, preorederIndex + 1, inorderValToIndex, left, inorderIndex - 1);
    node.right =
        buildTreeHelper(
            preorder,
            preorederIndex + (inorderIndex - left) + 1,
            inorderValToIndex,
            inorderIndex + 1,
            right);
    return node;
  }
}
