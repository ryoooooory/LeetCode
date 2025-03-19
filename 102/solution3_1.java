/** いただいたコメントを元にした解法 再帰部分での条件式をより読み手に伝わり例外なくListがある状態になることが一目でわかるようにwhileを使用。（読み手への配慮） */
public class solution3_1 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> values = new ArrayList<>();
    levelOrderHelper(root, 0, values);
    return values;
  }

  private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> values) {
    if (node == null) {
      return;
    }
    while (values.size() <= level) {
      values.add(new ArrayList<>());
    }
    values.get(level).add(node.val);
    levelOrderHelper(node.left, level + 1, values);
    levelOrderHelper(node.right, level + 1, values);
  }
}
