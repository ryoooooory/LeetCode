/*
・概要
LeetCodeの解説や他の人の解法を見たもの
https://github.com/Ryotaro25/leetcode_first60/pull/50/files#diff-776c4af48e8dabf508f652032b95d33f3ef8308547e1fdd2dc55e447d6bc1af8R26

自分の言葉で頭を整理する。

・解法
再帰を使わずに繰り返し処理で実装したもの
考え方は再帰と一緒だが、再帰のbottomupと違って、根から順々に処理していくので、上から順に木を繋げていく。
繰り返し処理の部分は、再帰と一緒で現在の木の値がtarget以下かどうかで処理を分ける。
現在見ている木の値がtarget以下の時は、target以下の木に繋げていく。現在のtarget以下の木の現在みているものをXとする。ここで気になるのはXの左右のどちらに繋ぐかということだが、
Xの左の部分木は必ずtarget以下となっていて、そもそも探索する必要がないので探索してXに繋ぐ可能性があるのはXの右の部分木に含まれる木であり、つまりXより大きい値なのでXの右に繋ぐしかない。
上記である通り、次に探索するのは現在の木の右の部分木となる。
またこのときtarget以下の木についても現在の木に更新し、かつその木の右の部分木はtargetより大きい可能性もあるのでnullにする。
現在見ている木の値がtarget以上の時も、上記と同様に行なっていく
*/

public class solution2_2 {
  public TreeNode[] splitBST(TreeNode root, int target) {
    TreeNode current = root;
    TreeNode smallDummy = new TreeNode(0);
    TreeNode largeDummy = new TreeNode(0);
    TreeNode smallTail = smallDummy;
    TreeNode largeTail = largeDummy;

    while (current != null) {
      if (current.val <= target) {
        smallTail.right = current;
        smallTail = current;
        current = current.right;
        smallTail.right = null;
      } else {
        largeTail.left = current;
        largeTail = current;
        current = current.left;
        largeTail.left = null;
      }
    }
    return new TreeNode[] {smallDummy.right, largeDummy.left};
  }
}
