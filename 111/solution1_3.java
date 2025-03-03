import java.util.ArrayDeque;
import java.util.Queue;
import javax.swing.tree.TreeNode;

/** 自力解法。 BFSでの解法。最短経路の問題なので、こちらのがDFSより効率的かと思う。 ただメモリについては、O(n) n:node数　なので、10^5くらいとなる。 */
public class solution1_3 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int depth = 0;
    while (!nodes.isEmpty()) {
      depth++;
      int numOfCurrentDepthNodes = nodes.size();
      for (int i = 0; i < numOfCurrentDepthNodes; i++) {
        TreeNode current = nodes.poll();
        if (current.left == null && current.right == null) {
          return depth;
        }
        if (current.left != null) {
          nodes.offer(current.left);
        }
        if (current.right != null) {
          nodes.offer(current.right);
        }
      }
    }
    return depth;
  }
}
