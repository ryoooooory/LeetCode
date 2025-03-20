/**
 * 自力解放。5分くらいでAC。 時間計算量O(n), 空間計算量O(n)
 * n:全要素数。再帰の深さは最大で全要素数になり、今回の問題の制約は10^4なので結構あぶないかもしれないが一旦再帰でかいてみる
 * 解法としては、木を再帰的に探索してその時点での左の最大値と右の最小値と現在の値を比較することを考えたが、処理が難しそうだなと思って、一旦左の木を優先で見る方針(inorder)で探索してListに要素をつめていき、最後にsortされているかを確認する方法にした。
 */
public class solution1_1 {
  public boolean isValidBST(TreeNode root) {
    List<Integer> allValues = new ArrayList<Integer>();
    searchAllNodes(root, allValues);

    for (int i = 0; i < allValues.size() - 1; i++) {
      if (allValues.get(i + 1) <= allValues.get(i)) {
        return false;
      }
    }
    return true;
  }

  private void searchAllNodes(TreeNode node, List<Integer> allValues) {
    if (node == null) {
      return;
    }
    searchAllNodes(node.left, allValues);
    allValues.add(node.val);
    searchAllNodes(node.right, allValues);
  }
}
