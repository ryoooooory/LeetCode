/*
・概要
他の人のMRをみた
https://github.com/Satorien/LeetCode/pull/53/files
https://github.com/shintaro1993/arai60/pull/58/files
今更気づいたが、配列をinplaceで処理するだけでいいので、別にListとか追加でデータ構造使ってもいいやんと気づく（ちょっと落ち着こう）
solution2_1についても一旦0でない数をストックしておき、ループで左から詰めていき、最後に0をいれていく。

https://github.com/olsen-blue/Arai60/pull/55/files
ですよね、バブルソートっぽいなとおもったひとがいてよかった。
たしかにinplaceでって指定があるので、追加のデータ構造使わないよなとなるのは無理も無いですよね。

Erase–remove idiomについてChatGPTで聞いてみた。
Erase–remove idiomとはC++における定番テクニックで、remove で「消したい要素を後ろに寄せ」、erase で「実際にコンテナから削除する」この 2段階をセットで行う手法をErase–remove idiom と呼びます。
例を見る限り、たしかにこの問題とイメージ同じだなと思った。
https://cplusplus.com/reference/algorithm/remove/


*/
public class solution2_2 {
  public void moveZeroes(int[] nums) {
    List<Integer> nonZeroNums = new ArrayList<>();
    for (int num : nums) {
      if (num != 0) {
        nonZeroNums.add(num);
      }
    }
    for (int i = 0; i < nonZeroNums.size(); i++) {
      nums[i] = nonZeroNums.get(i);
    }
    for (int i = nonZeroNums.size(); i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
