/**
 * いただいたコメントを元に修正したもの。
 * solution1_1.javaでnullの場合Integer.MAXVALUEを使ったが、あまり自然でなくかつ使わなくても0返すだけでいいのでシンプルに実装した。
 * あとからLeetCodeの解法をみたがほぼ同じだった。
 */
public class solution3_1 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    }
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
