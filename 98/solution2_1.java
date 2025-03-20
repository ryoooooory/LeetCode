/**
 * LeetCodeの解法を参考にしたもの。 自力解法の時に最初に考えた探索時点で判定するもの。
 * 解法としては、BSTの性質から、すべての要素は左のすべての要素より大きく、右の全ての要素より小さくなければいけない。
 * 根からおりて、最大値と最小値が渡されていくイメージ。（現在のNodeからみて左と右の全てのNodeをみるのと逆の発想） *
 * 最近helperを使いすぎている気がするのでもう少しいい名称を考えたい。（ただisValidBSTですべて言われている気もしている。https://github.com/olsen-blue/Arai60/pull/28/filesでも同じようなこと考えていた。）
 *
 * <p>この解法の派生としてhttps://github.com/seal-azarashi/leetcode/pull/27/filesでは、nullでなくLongの最大・最小値を使うことで対応している。(こちらのが記述量は減るが、関係ない値が使われるので初見だとどうしてこの値なのかみたいに考えそうなのでトレードオフかという気持ち)
 */
public class solution2_1 {
  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, null, null);
  }

  private boolean isValidBSTHelper(TreeNode node, Integer low, Integer high) {
    if (node == null) {
      return true;
    }
    if (low != null && node.val <= low) {
      return false;
    }
    if (high != null && high <= node.val) {
      return false;
    }
    return isValidBSTHelper(node.left, low, node.val)
        && isValidBSTHelper(node.right, node.val, high);
  }
}
