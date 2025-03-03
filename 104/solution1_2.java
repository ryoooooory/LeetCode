import java.util.ArrayDeque;
import java.util.Queue;
import javax.swing.tree.TreeNode;

/** 自力解法 2分ほどでAC 時間計算量O(2^n) n:木の深さ、空間計算量O(2^n) BFSバージョンで書いてみた。 */
public class solution1_2 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int maxDepth = 0;
    while (!nodes.isEmpty()) {
      maxDepth++;
      int numOfCurrentNodes = nodes.size();
      for (int i = 0; i < numOfCurrentNodes; i++) {
        TreeNode current = nodes.poll();
        if (current.left != null) {
          nodes.offer(current.left);
        }
        if (current.right != null) {
          nodes.offer(current.right);
        }
      }
    }
    return maxDepth;
  }
}
