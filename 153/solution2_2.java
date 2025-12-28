/*
・概要
https://github.com/nanae772/leetcode-arai60/pull/41/files
こちらを参考に、今度は配列の最初の要素と比較する方法で実装してみる。
・詳細
配列の最初の要素とmidを比較して、midの方が大きければ、最小値はmidの右側にあることがわかるので、left = mid + 1とする。
逆にmidの方が小さければ、最小値はmidかmidを含めて左側にあることがわかるので、right = midとする。
注意点として、配列が回転していない場合を考慮する必要があるので、最初にnums[left] < nums[right]の場合はnums[0]を返すようにしている。
・見つけたいもの
nums[0]より小さくなるところの最小のindex　（配列が単調増加のときは除く）
・定義
left: これより下のindexにはnums[0]以上の値しか存在しないことがわかっている範囲の左端のindex
right: このindex以上のindexにはnums[0]以下の値しか存在しないことがわかっている範囲の右端のindex
・更新処理
nums[0] <= nums[mid]のとき、left = mid + 1
nums[0] > nums[mid]のとき、right = mid
・終了条件
left == right

上記でACなのだが、やはり定義の大事さに気づき、定義を少し変えてみること更新処理や終了条件がどうなるかを考えてみた。
・見つけたいもの
nums[0]より小さくなるところの最小のindex　（配列が単調増加のときは除く）　　　これは上と一緒
・定義
left: これより下のindexにはnums[0]以上の値しか存在しないことがわかっている範囲の左端のindex
right: これより上のindexにはnums[0]以下の値しか存在しないことがわかっている範囲の右端のindex
・更新処理
nums[0] <= nums[mid]のとき、left = mid + 1
nums[0] > nums[mid]のとき、right = mid - 1
・終了条件
定義より、最終的な状態はleft,rightがとなりあって大小が逆転しているときである。[3,4,5,1,2]のとき、left = 3, right = 2のときに終了するイメージ。
right < left

・所感
定義を変えると更新処理や終了条件がどうなるかを考え、理解を深めるのに良い練習でした。やはりDiscordでの議論にもある通り形式で覚えるのでなく、自分の言葉で定義して理解することが重要だと再認識しました。
*/

public class solution2_2 {

  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    if (nums[left] < nums[right]) {
      return nums[0];
    }
    int numsFirstValue = nums[0];
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (numsFirstValue <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

  // 定義変えたバージョン
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    if (nums[left] <= nums[right]) {
      return nums[0];
    }
    int numsFirstValue = nums[0];
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (numsFirstValue <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return nums[left];
  }
}
