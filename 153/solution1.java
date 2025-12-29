/*
・概要
自力解答。５分くらいでAC

・解き方
回転している配列の最小値を見つける問題。
二分探索で解くことを考えた。
前問の35で学んだ変数の意味付け、更新の仕方、終了条件をしっかりと自分の言葉で定義してから実装に入った。

・詳細
- 定義
left: 最小値が存在しうる範囲の左端のindex
right: 最小値が存在しうる範囲の右端のindex
- ループ内処理
回転している配列の中で、右端の値とmidを比較してmidの方が大きければ、最小値はmidの右側にあることがわかるので、left = mid + 1とする。　[4,5,6,2,3]などが該当。
逆にmidの方が小さければ、最小値はmidかmidを含めて左側にあることがわかるので、right = midとする。[4,5,1,2,3]などが該当。
- 終了条件
left < rightとする。最終的にleft == rightになったときに、そのindexが最小値のindexになるので。

https://github.com/Ryotaro25/leetcode_first60/pull/46/files/5cd497a61c1610dfb252de6f0dd2a0823e7b2bec#r1973436282
この辺りも前の問題35の議論と同じで、変数の意味や更新の仕方、終了条件についてしっかりと定義しておくことが重要だと思った。

・計算量
時間計算量O(log n), 空間計算量O(1), nは配列の要素数
*/

public class solution1 {
  // 4,5,6,2,3
  // midが右よりおおきかったら、left = mid + 1
  // 4,5,1,2,3,4,5
  // midが右寄り小さかったら、今のindexか左にあるはずright = mid
  // 5,1,2,3,4
  // 最悪O(n)
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[right] < nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
