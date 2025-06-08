/**
 * 5分考えて解けなかったのでLeetCodeの解法を参考にしたもの。 preorderで見ていくんだろうなというところまではわかったが、rootのつぎをどう探索するのかがわからなかった。
 * 解法としては、やはりpreorderでみていくが、その次の左右木についてはinorderで左右が判定できることを元に、indexで左右木どちらかを判定していくというもの。 時間計算量:
 * O(n), 空間計算量: O(n) n:木の要素数、再帰の深さも最大でnとなる。今回は、制約として最大で3000なので、スタックサイズ的には大丈夫そう
 *
 * <p>他の人の解法もみてみた https://github.com/seal-azarashi/leetcode/pull/29/files
 * こちらのstep1ではpreorder、inorderを再帰ごとに範囲を狭めて際生成している。効率の面では自分の解法のが良さそうだが、クラス変数を使ってないのでマルチスレッドとかの場合は良さそう？（マルチスレッドでこれ使うかと言われると使わなそうなイメージ）
 * https://discord.com/channels/1084280443945353267/1237649827240742942/1265223555013152891でもあるようにクラス変数を使う場合は、どういう場面で問題がありそうなのか、実際使いそうなのか、代替案はどうなのかについて考えられると良さそう。
 * 問題点としてはスレッドセーフでないので、複数スレッドから同時にアクセスされるとクラス変数が競合して正しい期待値にならないことがある。
 * 実際にこのクラスをマルチスレッドで使うかと言われると正直わからない（inorder,oreorderからそれを満たすbinarytreeをつくることはあるのだろうか？）
 * 代替案1:　synchrinizedを使うことで、同時アクセスできる関数を１つにすること→ただしこれをするとマルチスレッドのメリットがなくなる。
 * 代替案2:　https://github.com/seal-azarashi/leetcode/pull/29/filesのようにクラス変数を使わずに引数で渡すようにする。
 */
public class solution1_1 {
  private int preorderIndex;
  Map<Integer, Integer> inorderIndices;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    inorderIndices = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndices.put(inorder[i], i);
    }
    return constructTree(preorder, 0, inorder.length - 1);
  }

  private TreeNode constructTree(int[] preorder, int left, int right) {
    if (right < left) {
      return null;
    }
    int nodeVal = preorder[preorderIndex++];
    TreeNode node = new TreeNode(nodeVal);
    node.left = constructTree(preorder, left, inorderIndices.get(nodeVal) - 1);
    node.right = constructTree(preorder, inorderIndices.get(nodeVal) + 1, right);
    return node;
  }
}
