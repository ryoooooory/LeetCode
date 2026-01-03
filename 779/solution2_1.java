/*
・概要
LeetCodeの解説や他の人の解法をみた。
https://github.com/Ryotaro25/leetcode_first60/pull/50/files

・解法
この問題では、元の木構造を保ちながら、target以下の値だけの木と、targetより大きい値の木に分けるという内容である。
solution1_1で直感的にできそうだが、
       8
  3       9
   4
     5
みたいな木でtargetが5のときに対応できない。
ということで根から各々木を降りながらみていく。各再帰で返す値は、その時点でのtarget以下の木とtargetより大きいだけの木である。
木の値がtarget以下であれば、左の部分木はBSTなのですべてその木の値以下なので構造を変える必要がない。逆に右の部分木はまだTarget以下の木がある可能性があるので、再帰で見る必要がある。
再帰でかえされる二つの木の内、target以下の木については、現在の値よりは大きいはず（元々自身の右の部分木の一部なので）なので、右の部分木にする。
木の値がtargetより大きい値であれば、先ほどと同様の動きで左の部分木をみていく。

・計算量
O(h): 木の深さ

・所感
簡単なテストケースのみで問題の本質を誤認してしまった。またBSTの内容を理解していれば、単純に親との関係を見るだけではダメなことは気付けだはず。
本質的な原因はテストケースの洗い出しが適当だったこと、LeetCodeのテストサンプルだけを鵜呑みにしたことが原因なので、
https://github.com/goto-untrapped/Arai60/pull/54/files
にあるとおり、シンプルケース→もうすこし難しいケース→エッジケースの流れの洗い出しを必ずするようにする（まだ仕事での取り組み方とLeetCodeでの問題のやり方を分離していてよくない。）

*/

public class solution2_1 {
  public TreeNode[] splitBST(TreeNode root, int target) {
    if (root == null) {
      return new TreeNode[2];
    }
    if (target < root.val) {
      TreeNode[] small = splitBST(root.left, target);
      root.left = leftSubTree[1];
      return new TreeNode[] {leftSubTree[0], root};
    } else {
      TreeNode[] rightSubTree = splitBST(root.right, target);
      root.right = rightSubTree[0];
      return new TreeNode[] {root, rightSubTree[1]};
    }
  }
}
