/**
 * https://github.com/olsen-blue/Arai60/pull/21/filesなどを参考にBFSについて、階層の切り分けを新しくQueueを使うことで対応したもの。
 * 個人的にはそんなにQueueのsizeで階層を表現することに違和感ないが、他の方は結構違和感をもっているイメージがあるので、どちらの考えでもできるようにしたい。
 */
public class solution2_2 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(root);
    int maxDepth = 0;
    while (!nodes.isEmpty()) {
      maxDepth++;
      Queue<TreeNode> nextLevelNodes = new ArrayDeque<>();
      while (!nodes.isEmpty()) {
        TreeNode current = nodes.poll();
        if (current.left != null) {
          nextLevelNodes.offer(current.left);
        }
        if (current.right != null) {
          nextLevelNodes.offer(current.right);
        }
      }
      nodes = nextLevelNodes;
    }
    return maxDepth;
  }
}
