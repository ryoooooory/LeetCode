/**
 * LeetCodeの解法や、https://github.com/seal-azarashi/leetcode/pull/26/filesを参考にしたもの
 * solution1_1であったListのreverseをなくして、代わりに追加する時点でaddFirst, addLastを使う。 最初add(0,
 * val)みたいにindex指定しようかなとおもったが、addFirstとかの方が明示的でわかりやすい
 *
 * <p>また、以前他のMRでいただいたコメントの通り、Queueを使わずにArrayListで行ってみた。
 *
 * <p>https://github.com/seal-azarashi/leetcode/pull/26/files
 * でもあるとおり、reverseのオーバーヘッドはあまり気にならなさそう（実際にLeetCode上でのACの時間も変わらなかった）
 */
public class solution2_1 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> allValues = new ArrayList<>();
    if (root == null) {
      return allValues;
    }
    List<TreeNode> nodes = new ArrayList<>();
    nodes.add(root);
    int level = 1;

    // 無限ループになっているが、実際は木構造で循環がなので必ず次の深さでの木の数0となる時が来て36行目でreturnされる。
    while (true) {
      List<Integer> currentLevelValues = new ArrayList<>();
      List<TreeNode> nextLevelNodes = new ArrayList<>();
      for (TreeNode node : nodes) {
        // isReversedみたいな変数のがいいかも？（levelといいつつ、最終的には反転していれるかどうかしか使ってないし）
        if (level % 2 != 0) {
          currentLevelValues.addLast(node.val);
        } else {
          currentLevelValues.addFirst(node.val);
        }
        if (node.left != null) {
          nextLevelNodes.add(node.left);
        }
        if (node.right != null) {
          nextLevelNodes.add(node.right);
        }
      }
      allValues.add(currentLevelValues);
      if (nextLevelNodes.isEmpty()) {
        return allValues;
      }
      nodes = nextLevelNodes;
      level++;
    }
  }
}
