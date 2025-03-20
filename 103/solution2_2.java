/** DFSバージョン。 意外と直感的でいいかもしれない 再帰は最大で木の要素数となる（直線）なる。制約的には2000なのでまあ多分大丈夫かなくらいの感触 */
public class solution2_2 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> allValues = new ArrayList<>();
    if (root == null) {
      return allValues;
    }
    zigzagLevelOrderHelper(root, allValues, 0);
    return allValues;
  }

  void zigzagLevelOrderHelper(TreeNode node, List<List<Integer>> allValues, int level) {
    if (node == null) {
      return;
    }
    List<Integer> currentLevelValues;
    while (allValues.size() <= level) {
      allValues.add(new ArrayList<>());
    }
    currentLevelValues = allValues.get(level);
    if (level % 2 == 0) {
      currentLevelValues.addLast(node.val);
    } else {
      currentLevelValues.addFirst(node.val);
    }
    zigzagLevelOrderHelper(node.left, allValues, level + 1);
    zigzagLevelOrderHelper(node.right, allValues, level + 1);
  }
}
