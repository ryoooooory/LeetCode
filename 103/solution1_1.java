/**
 * 自力解法。10分ほどでAC 時間計算量O(n), 空間計算量O(n), nは全要素数
 * 思考プロセスとしては、各階層を順にみていくということでBFS、階層ごとに左からと右からが変わるので階層にいれる順番は変わらずに、最後に反転することで対応(反転はO(n)かかるので冗長ではある)
 * 別の方法としてQueueとStackをあわせれば反転させなくてもできそうかもと思ったが、処理が結構むずかしそうかとおもいシンプルな方で実装した。
 *
 * <p>https://github.com/hroc135/leetcode/pull/26/filesをみて reverseの時間がどの程度かみているのがいいなと思った。
 * まず自分で考えてみると、クロック周波数を1Ghzとして、最大1000要素のreverseをすると感がると、1000/10^9 = 1μsと見積もった。
 * コメントなどをみて自分のPC（macbook air m2）のクロック周波数を調べてみたがどうやらMacは公表してないらしい（＋動的に動く）。ベンチマークとかだと3.5GHzくらいらしい。
 */
public class solution1_1 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> allValues = new ArrayList<>();
    if (root == null) {
      return allValues;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int level = 1;

    while (!nodes.isEmpty()) {
      List<Integer> currentLevelValues = new ArrayList<>();
      Queue<TreeNode> nextLevelNodes = new ArrayDeque<>();
      for (TreeNode node : nodes) {
        TreeNode current = nodes.poll();
        currentLevelValues.add(current.val);
        if (current.left != null) {
          nextLevelNodes.offer(current.left);
        }
        if (current.right != null) {
          nextLevelNodes.offer(current.right);
        }
      }
      if (level % 2 != 0) {
        allValues.add(currentLevelValues);
      } else {
        Collections.reverse(currentLevelValues);
        allValues.add(currentLevelValues);
      }
      nodes = nextLevelNodes;
      level++;
    }
    return allValues;
  }
}
