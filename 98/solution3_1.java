/*
 * ・概要
 * solution2まででコメントもらったところも踏まえたもの。
 * マルチスレッドでの呼び出しを考慮して、クラスプロパティを呼ばないように変更。
 * オートボクシングをさせないためにlongを引数とする（初期状態をIntegerの範囲外として判定するため）
 *
 *　・その他
 * オートボクシング：基本データ型（プリミティブ型: intとか）と、そのラッパークラス(Integerとか)との自動的な変換。https://docs.oracle.com/javase/jp/8/docs/technotes/guides/language/autoboxing.html
 * プリミティブをラッパーに変換するのをボクシング、逆をオートボクシングと呼ぶ。Docにあるとおり可読性はあがるがパフォーマンスの負荷がかかる。
 */
public class solution3_1 {
  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBSTHelper(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min) {
      return false;
    }
    if (max <= node.val) {
      return false;
    }
    return isValidBSTHelper(node.left, min, node.val)
        && isValidBSTHelper(node.right, node.val, max);
  }
}
