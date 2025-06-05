/*
 * ・概要
 * 他の人のを参照し、リファクタリングしたもの。
 * solution1_1の問題だったマルチスレッドで懸念を解消するためにクラスプロパティを使わずに対応したもので、solution2_2の派生版。
 * https://github.com/shintaro1993/arai60/pull/33/files を参考にし、そもそもindexの保持に参照を使わなくても、左の木はindexが現在より+1され、右の木は現在のindex+左の木の数+1となることを考えると、
 * そもそも参照にする必要もないことにきづいた。solution2_1よりスッキリしてよさそう。
 *
 * ・計算量
 * 時間計算量O(n), 空間計算量: O(n) n:木の要素数、再帰の深さも最大でn,
 *
 * ・その他
 * LeetCodeの制約的には問題ないが、preorder, inorderで要素が一致してない時の例外処理などは議論する必要がありそう。基本的には最初にvalidateするのが良さそう。
 * 上記の対応方針としてはエラーを吐くかnullを返すとかが選択肢にあるかと思う。
 */

public class solution2_2 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderIndices = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndices.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, inorderIndices, 0, preorder.length - 1);
  }

  private TreeNode buildTreeHelper(
      int[] preorder, int index, Map<Integer, Integer> inorderIndices, int left, int right) {
    if (right < left) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[index]);
    int inorderIndex = inorderIndices.get(node.val);
    node.left = buildTreeHelper(preorder, index + 1, inorderIndices, left, inorderIndex - 1);
    node.right =
        buildTreeHelper(
            preorder, index + (inorderIndex - left) + 1, inorderIndices, inorderIndex + 1, right);
    return node;
  }
}
