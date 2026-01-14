/*
・概要
他の人の解法を参考に見直したもの。
https://github.com/t9a-dev/LeetCode_arai60/pull/41

・upper_bound, lower_boundについて
upperBoundは、配列の中でtargetより大きい最初の要素のインデックスを返す関数。[1,3,5,5,6], 5 -> 4 (5よりおおきい6のインデックス)
lowerBoundは、配列の中でtarget以上の最初の要素のインデックスを返す関数。[1,3,5,5,6], 5 -> 2 (5以上の5のインデックス)
upperBoundの実装については、指定値が配列の最大値より大きい可能性があるので初期値のrightをnums.lengthにしている点がポイント。
また、ループの条件もleft < rightとしている点もポイント。（left == rightのときは探索終了なので）
ループの中については、midの値がtarget未満の場合はleftをmid + 1に更新し、そうでない場合はrightをmidに更新するというもの。

・今回の問題について
今回の問題はnums内にtargetが存在する場合はそのインデックスを、存在しない場合はtargetを挿入する位置のインデックスを返す問題となっているので、自然な解法はsolution1だが、
よく考えると、lowerBoundを実装すれば同じことができるので、そちらで解いてみた。（実際のはtagetが見つかった瞬間に早期リターンがあるsolution1の方がはやい。具体的には[1,2,2,2,2,2,2,2,2,2,2,2],target = 2 みたいなときにはやい）

https://discord.com/channels/1084280443945353267/1192736784354918470/1199018938005213234
などにもいろいろ議論があり、結果として
https://discord.com/channels/1084280443945353267/1192736784354918470/1199018938005213234
https://github.com/garunitule/coding_practice/commit/90157e1554005872e0fb4b709a99115442923ec6
のように、条件や変数指定について日本語で表せていないなと思ったので再度まとめる。

・再まとめ
- 定義や変数
見つけたいもの：target以上のindexの中で最小のもの。配列は単調増加している。
left: targetを挿入する可能性のあるインデックスの候補の中で左端のインデックス。
right: targetを挿入する可能性のあるインデックスの候補の中で右端のインデックス

- ループ内処理
対象のindexを探す時はleftとrightの真ん中のindexの値を見た時に、target未満であればmid以下のindexにtargetが存在することはないので、見る対象の区間を更新する際にleft = mid + 1とする。
逆にmidがtarget以上であれば、そのindexが答えになる or 見つけたいものはそれより左にある可能性があるので、right = midとする。
- 更新の時の動き
更新の際のleft, rightの動きをみていくと必ずleftとrightは距離が近づいていく。なぜなら更新の際にleftについてはmid + 1なので大きくなるとは自明だが、rightについても、rightの位置が変わらないのはright == midのときだけであり、
この時は必然的にleft == rightのときのみだからである。関連してleftとrightが隣り合ってる時（right = left + 1）は、mid = left + (right - left) / 2 = left + 1 / 2 = leftとなるのでrightを更新するとしてもright = mid = leftとなり、更新前と比べて -1だけindexが小さくなっていることが分かる。
もっと数式的に考えると、mid = left + (right - left) / 2 とすると、left <= mid < right が成り立つので、
1, left = mid + 1のとき
新しい区間長len = right - left = right - (mid + 1) < right - left（旧区間）となり区間は必ず小さくなる。
2, right = midのとき
新しい区間長len = right - left = mid - left < right - left（旧区間）となり区間は必ず小さくなる。
ということで区間更新時は必ずleftとrightの距離が縮まることが分かる。

- 終了条件
見つけたいものがみつかった時としては、left == rightになったときなので、ループ条件はleft < rightとする。
*/

public class solution2 {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
