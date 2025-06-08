/*
 * ・概要
 * 他の人のを参照し、リファクタリングしたもの。
 * solution2_2のStackバージョン。
 * 思考の流れとしては、再帰と違って戻り値が返せないので今回はleftLimitと現在のindexをくらべて左の木が存在する時はすぐにその時点で木を値ありで生成するようにしている。
 * 参考：https://github.com/shintaro1993/arai60/pull/33/files#diff-a286a96e11af3976f76d77e55be1edb9b540b1e2f1aabed1da12171208a553bcR82
 *
 * 再帰でかけるものは基本的にStackでかける。再帰と違ってStackOverflowにはならないが限界はあるので注意。Stack（java.util.Stack）の限界サイズはヒープサイズによって決まるがオプションによっては1GBまでいけるらしい。
 * call stackのサイズ（再帰の限界）もオプションにおるが大体数MBらしい
 *
 * ・計算量
 * 時間計算量O(n), 空間計算量: O(n) n:木の要素数、再帰の深さも最大でn,
 *
 * ・その他
 * 所感だがやはり再帰のが直感的な気持ちではあるが、メリデメがちゃんとあるので選択肢として使えるようにしなければと思った。
 * Stackについては基本的にDeque（両端キュー）のインターフェイスを優先するらしい。　https://docs.oracle.com/javase/jp/8/docs/api/java/util/Deque.html
 * ArrayDequeはStack（java.util.Stack）より高速らしい（Queueとして使う時はLinkedListより速いらしい。） https://docs.oracle.com/javase/jp/8/docs/api/java/util/ArrayDeque.html
 * ArrayDequeはスレッドセーフでないので、スレッドセーフを求める時はConcurrentLinkedDequeを使うといいらしい。ただしArrayDequeとかよりは遅いらしい。
 */

public class solution2_3 {

  private record NodeInfo(TreeNode node, int preorderIndex, int leftLimit, int rightLimit) {}

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderIndices = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndices.put(inorder[i], i);
    }

    Deque<NodeInfo> nodes = new ArrayDeque<>();
    TreeNode root = new TreeNode(preorder[0]);
    nodes.push(new NodeInfo(root, 0, 0, preorder.length - 1));

    while (!nodes.isEmpty()) {
      NodeInfo info = nodes.pop();
      int rootVal = preorder[info.preorderIndex];
      int inorderIndex = inorderIndices.get(rootVal);

      int leftSize = inorderIndex - info.leftLimit;

      if (info.leftLimit < inorderIndex) {
        TreeNode left = new TreeNode(preorder[info.preorderIndex + 1]);
        info.node.left = left;
        nodes.push(new NodeInfo(left, info.preorderIndex + 1, info.leftLimit, inorderIndex - 1));
      }

      if (inorderIndex < info.rightLimit) {
        int rightPreIndex = info.preorderIndex + leftSize + 1;
        TreeNode right = new TreeNode(preorder[rightPreIndex]);
        info.node.right = right;
        nodes.push(new NodeInfo(right, rightPreIndex, inorderIndex + 1, info.rightLimit));
      }
    }

    return root;
  }
}
