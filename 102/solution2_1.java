/**
 * LeetCodeの解法を参考にしたもの。 DFSでの解法。 BFSでなくともlevelで引数として渡せばOKという解法. stackつかってもできる。
 * 今回は、再帰の深さは最大で要素数nとなり、問題の制約は2000なのでまあ多分大丈夫かくらい
 *
 * <p>https://github.com/t0hsumi/leetcode/pull/26/files
 * https://github.com/seal-azarashi/leetcode/pull/25/files でも大体同じ解法
 */
public class solution2_1 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> values =
        new ArrayList<>(); // https://github.com/t0hsumi/leetcode/pull/26/filesとかだとlevel_ordered_valuesにしてもう少し具体的にしてる。
    levelOrderHelper(root, 0, values);
    return values;
  }

  private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> values) {
    if (node == null) {
      return;
    }
    if (values.size() == level) {
      values.add(new ArrayList<>());
    }
    List<Integer> list = values.get(level);
    list.add(node.val);
    levelOrderHelper(node.left, level + 1, values);
    levelOrderHelper(node.right, level + 1, values);
  }
}
