/**
 * いただいたコメントを元にした解法
 * ArrayListは内部で配列をつかうので、追加、削除についてはO(n)となってしまう。なので今回みたいに繰り返し追加が行われる時にはLinkedListを使う。
 */
public class solution3_1 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> allValues = new ArrayList<>();
    zigzagLevelOrderHelper(root, allValues, 0);
    return allValues;
  }

  void zigzagLevelOrderHelper(TreeNode node, List<List<Integer>> allValues, int level) {
    if (node == null) {
      return;
    }
    List<Integer> currentLevelValues;
    while (allValues.size() <= level) {
      allValues.add(new LinkedList<>());
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
