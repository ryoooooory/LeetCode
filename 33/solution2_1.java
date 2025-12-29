/*
・概要
https://github.com/skypenguins/coding-practice/pull/29/files#r2558426858
を参照に、solution1_1でできなかった１度の二分探索で解く方法を実装。


・解き方
1, 定義
left: targetが存在する可能性がない範囲の右端index
right: targetが存在する可能性がある範囲の右端index
2, 更新処理
midを求め、nums[mid] == targetならmidを返す
target < nums[mid]のとき、次はnums[mid]が回転の左にいるか右にいるかをみる。
右の時ときは、targetは確実にmidの左側にいるので、right = midとする。[6,0,1,2,3]のとき、target = 0, mid = 2(val = 1)のときのように。
左の時は、まだtargetがどちらにいるか確定していないので（[4,5,6,2,3]のとき、target = 2, mid = 2(val = 6)のとき、targetは回転のどちら側にいる可能性もあり、その場合探索範囲が変わるので）
よって、さらにtargetが回転の右にいるか左にいるかみる必要がみて、回転の左にいれば、right = mid、回転の右にいれば、left = mid + 1とする。
target > nums[mid]のときも同様に考える。

上記を実装したのが2_1となるが、targetの回転位置をみる部分が共通なので、共通化したのが2_2となる。

・その他
https://github.com/shintaro1993/arai60/pull/47/files
最近の自分の解法同様にleft, rightの定義をおこなっている。特にhttps://github.com/shintaro1993/arai60/pull/47/files#r2415330406がいいコメントだと思った。
解法も条件式としては、まずmidが回転のどっちにあるかみて、左の場合はその後に、targetとmidとnums[0](左端)をみてる。これは回転の左が単調増加であるからだ。この考えはかなり直感的でいなと思った。
ということで別解としてこちらも実装してみた。
*/

public class solution2_1 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target < nums[mid]) {
        if (nums[mid] < nums[nums.length - 1]) {
          right = mid;
        } else {
          if (target <= nums[nums.length - 1]) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
      } else {
        if (nums[nums.length - 1] < nums[mid]) {
          left = mid + 1;
        } else {
          if (target <= nums[nums.length - 1]) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }

  // 以下、共通化
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target < nums[mid]) {
        if (nums[mid] < nums[nums.length - 1]) {
          right = mid;
          continue;
        }
      } else {
        if (nums[nums.length - 1] < nums[mid]) {
          left = mid + 1;
          continue;
        }
      }
      if (target <= nums[nums.length - 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }

  // 別解
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[nums.length - 1] < nums[mid]) {
        if (nums[0] <= target && target < nums[mid]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[nums.length - 1]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }
}
