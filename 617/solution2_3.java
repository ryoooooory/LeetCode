/**
 * https://github.com/seal-azarashi/leetcode/pull/22/filesなどを参考にStackを用いたDFS
 * 左と右でほぼ同様の処理をしているが、うまく関数として切り出せなかった。。
 * 実装中に恥ずかしながら左右木が両方nullのときは、mergeをnullにするだけでいいと誤認していたが、mergeをnullにしても、その親の木からの参照はnullにならずに悩んだ。
 * 変数mergeをnullにしてもmergeの参照先がnullになるだけで、親の木がみている元々の参照は残り続けるから→特にNode系を扱う時は参照がどうなっているのかをしっかり意識したい。
 */
public class solution2_3 {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

    if (root1 == null && root2 == null) {
      return null;
    }
    // 配列でやってるが、構造体を用意してもいい。
    Stack<TreeNode[]> nodesForMerge = new Stack<>();
    TreeNode mergedTree = new TreeNode();
    if (root1 == null) {
      mergedTree.val = root2.val;
    } else if (root2 == null) {
      mergedTree.val = root1.val;
    } else {
      mergedTree.val = root1.val + root2.val;
    }
    nodesForMerge.push(new TreeNode[] {mergedTree, root1, root2});

    while (!nodesForMerge.isEmpty()) {
      TreeNode[] nodes = nodesForMerge.pop();
      TreeNode merge = nodes[0];
      TreeNode left = nodes[1];
      TreeNode right = nodes[2];

      TreeNode nextMergedLeftNode = new TreeNode();
      if (left == null) {
        merge.val = right.val;
        if (right.left != null) {
          merge.left = nextMergedLeftNode;
          nodesForMerge.push(new TreeNode[] {nextMergedLeftNode, null, right.left});
        }
      } else if (right == null) {
        merge.val = left.val;
        if (left.left != null) {
          merge.left = nextMergedLeftNode;
          nodesForMerge.push(new TreeNode[] {nextMergedLeftNode, left.left, null});
        }
      } else {
        merge.val = left.val + right.val;
        if (left.left != null || right.left != null) {
          merge.left = nextMergedLeftNode;
          nodesForMerge.push(new TreeNode[] {nextMergedLeftNode, left.left, right.left});
        }
      }

      TreeNode nextMergedRightNode = new TreeNode();
      if (left == null) {
        merge.val = right.val;
        if (right.right != null) {
          nodesForMerge.push(new TreeNode[] {nextMergedRightNode, null, right.right});
          merge.right = nextMergedRightNode;
        }
      } else if (right == null) {
        merge.val = left.val;
        if (left.right != null) {
          nodesForMerge.push(new TreeNode[] {nextMergedRightNode, left.right, null});
          merge.right = nextMergedRightNode;
        }
      } else {
        merge.val = left.val + right.val;
        if (left.right != null || right.right != null) {
          nodesForMerge.push(new TreeNode[] {nextMergedRightNode, left.right, right.right});
          merge.right = nextMergedRightNode;
        }
      }
    }
    return mergedTree;
  }
}
