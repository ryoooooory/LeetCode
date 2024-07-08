# 373. Find K Pairs with Smallest Sums

## step1
時間計算量: O(klogk), 空間計算量: O(k)
全探索しか思い浮かばず、ACできなかった。
回答をみて理解してその通りに実装（変数名のリネームはおこなった。）

## step2
他の人の実装を参考に実装した。
### step2-1
参考：https://github.com/seal-azarashi/leetcode/pull/10/files
根本的な解法はstep1と同じだが、PriorityQueueにいれる中身を変えて、変数を少なくしたタイプ。変数宣言での記述量は増えるものの、繰り返しの部分は余計な合計などもなくわかりやすいかなとおもった。

### step2-2
参考：[https://github.com/seal-azarashi/leetcode/pull/10/files](https://github.com/kazukiii/leetcode/pull/11/files)
実装していて、Pairを使わない場合は独自で定義したほうが見やすいなあとおもっていて同様のコメントが上記のPRでもあったので、独自定義する方針でも実装してみた。
