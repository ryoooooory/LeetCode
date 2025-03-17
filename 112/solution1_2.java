import java.util.ArrayDeque;
import java.util.Queue;
import javax.swing.tree.TreeNode;

/** 自力解法。 BFSで実装してみた。 BFSの場合、空間計算量については、平衡木の場合はO(n), 一直線だとQueueに１つずつしか入らないのでO(1)になる。 */
public class solution1_2 {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    Queue<RootSum> rootSum = new ArrayDeque<>();
    rootSum.offer(new RootSum(root, root.val));
    while (!rootSum.isEmpty()) {
      RootSum current = rootSum.poll();
      TreeNode currentNode = current.node;
      int currentSum = current.sum;
      if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
        return true;
      }
      if (currentNode.left != null) {
        rootSum.offer(new RootSum(currentNode.left, currentSum + currentNode.left.val));
      }
      if (currentNode.right != null) {
        rootSum.offer(new RootSum(currentNode.right, currentSum + currentNode.right.val));
      }

if (currentNode.left != null || currentNode.right != null) {
if (currentNode.left != null) {
rootSum.offer(new RootSum(currentNode.left, currentSum + currentNode.left.val));
}
if (currentNode.right != null) {
rootSum.offer(new RootSum(currentNode.right, currentSum + currentNode.right.val));
}
continue;
}
// リーフノードで目標の合計値なら true
if (currentSum == targetSum) {
return true;
｝
    }
    return false;
  }

  record RootSum(TreeNode node, int sum) {}
  ;
}
