/*
 * ・概要
 * 他の人のを参照し、リファクタリングしたもの。
 * solution1_1の問題だったマルチスレッドで懸念を解消するためにクラスプロパティを使わずに対応したもの。
 * よくよく考えると、引数内で引き回せる参照となればいいと思ったので、独自クラスを作ることで対応した。
 * https://github.com/seal-azarashi/leetcode/pull/29/files のメンバー変数を使わない方法では配列を用いることで対応している。（配列も参照なので[0]だけ更新する形。）
 * こちらの解法と動き的にはほぼ一緒だが気持ち専用のクラスをつくっているこちらのが読みやすそう？
 *
 * ・計算量
 * 時間計算量O(n), 空間計算量: O(n) n:木の要素数、再帰の深さも最大でn
 *
 * ・補足
 * マルチスレッドでスレッドセーフな値かつインクリメント、ディクリメントが主なデータ操作の場合はAtomicIntegerが使える。（APIをまとめるControllerとかのクラスプロパティで何回API読んだのかを保持する値とかに使えそう）
 * (https://docs.oracle.com/javase/jp/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html)
 * 今回は引数を参照とすることで解消する方針にしたので、特に使用目的が合っているわけではない（使っても挙動が同じになるが）ので使わない。
 */

public class solution2_1 {
  private class IndexHolder {
    int index;

    IndexHolder(int index) {
      this.index = index;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderIndices = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndices.put(inorder[i], i);
    }
    IndexHolder index = new IndexHolder(0);
    return constructTree(preorder, index, inorderIndices, 0, inorder.length - 1);
  }

  private TreeNode constructTree(
      int[] preorder,
      IndexHolder preorderIndex,
      Map<Integer, Integer> inorderIndices,
      int left,
      int right) {
    if (right < left) {
      return null;
    }
    int nodeVal = preorder[preorderIndex.index];
    preorderIndex.index++;
    TreeNode node = new TreeNode(nodeVal);
    node.left =
        constructTree(
            preorder, preorderIndex, inorderIndices, left, inorderIndices.get(nodeVal) - 1);
    node.right =
        constructTree(
            preorder, preorderIndex, inorderIndices, inorderIndices.get(nodeVal) + 1, right);
    return node;
  }
}
