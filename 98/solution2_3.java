/**
 * https://github.com/seal-azarashi/leetcode/pull/27/filesや、solution1_1でもあるとおり再帰だとstackoverflowの可能性があるので、スタックを使って対応したもの
 * NodeInfoは命名微妙な気がする（NodeValueLimitとかのがいい？） 上記のPRではArrayDequeを使っていたので、Stackとの違いを調べた。
 * Stack=同期ありなので、マルチスレッドではいいが、オーバーヘッドがある。 ArrayDeque=同期は手動でする必要があるがリングバッファベースで実装されているので高速
 * 結論としてはシングルスレッドならArrayDequeを使った方がよい
 */
public class solution2_3 {
  private record NodeInfo(TreeNode node, Integer low, Integer high) {}
  ;

  public boolean isValidBST(TreeNode root) {

    ArrayDeque test = new ArrayDeque<>();
    if (root == null) {
      return true;
    }
    Stack<NodeInfo> nodes =
        new Stack<>(); // ArrayDequeとの比較：シングルスレッドならArrayDeque、マルチスレッドならStackも選択肢に入る
    nodes.push(new NodeInfo(root, null, null));
    while (!nodes.isEmpty()) {
      NodeInfo current = nodes.pop();
      if (current.node == null) {
        continue;
      }
      if (current.low != null && current.node.val <= current.low) {
        return false;
      }
      if (current.high != null && current.high <= current.node.val) {
        return false;
      }
      nodes.push(new NodeInfo(current.node.left, current.low, current.node.val));
      nodes.push(new NodeInfo(current.node.right, current.node.val, current.high));
    }
    return true;
  }
}
