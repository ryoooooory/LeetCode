# 373. Find K Pairs with Smallest Sums

## step1
時間計算量: O(klogk), 空間計算量: O(k)
全探索しか思い浮かばず、ACできなかった。
回答をみて理解してその通りに実装（変数名のリネームはおこなった。）
大まかな思考の流れは以下の通り
1, 単純に全探索→ソートすると計算量がよくないので、改善のためにどのように比較をするかを考える
2, 実際に比較をするのは、最小のペア（nums1[index1], nums2[index2]）を基準に考えると、次の最小値は(nums1[index1 + 1], nums2[index2], nums1[index1], nums2[index2 + 1])かもしくは、この以前のステップでのこったもののどれかとなる。
3, 上記で以前のステップでのこったものを実現すること、常にソートされた状態でいることを考慮してHeapを使うという流れとなる。
4, あとは追加の際に重複をさけるため、Setを用意して重複のIndexペアは弾くようにする。

## step2
他の人の実装を参考に実装した。
### step2-1
参考：https://github.com/seal-azarashi/leetcode/pull/10/files
根本的な解法はstep1と同じだが、PriorityQueueにいれる中身を変えて、変数を少なくしたタイプ。変数宣言での記述量は増えるものの、繰り返しの部分は余計な合計などもなくわかりやすいかなとおもった。

### step2-2
参考：[https://github.com/seal-azarashi/leetcode/pull/10/files](https://github.com/kazukiii/leetcode/pull/11/files)
実装していて、indexまわりをまとめて独自で定義したほうが見やすいなあとおもっていて同様のコメントが上記のPRでもあったので、独自定義する方針でも実装してみた。

## メモ
Loopの表現についてfor, whileの議論が他のPRのコメントでもあったが、宣言的か手続的のどちらがいいかというものがあり、今回の問題だと個人的にはどちらでもそこまで変わらないかなと思ったが問題や条件によってはどちらが自然かというのを常に意識したい。
また問題文の制約次第ではループのなかでエラーとなる可能性があることも意識したい。
https://github.com/sakupan102/arai60-practice/pull/11#discussion_r1622031840
https://github.com/fhiyo/leetcode/pull/13/files
