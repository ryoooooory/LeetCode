# FirstSolution

５分ほどでとけた。以前に解いたことがあり、carry がある場合の処理も忘れていなかった。

# SecondSolution

https://github.com/TORUS0818/leetcode/pull/7
を参考に再帰を使って解いた。
興味深かったのは、https://github.com/fhiyo/leetcode/pull/5/filesでスタックサイズの限界をおおよそ見積もっている点だった。
スタックが積まれる認識はもっていたが、具体的な数値を見積もってはいなかったので自分でも見積もることにした。
メモリ使用量としては、再帰の深さ D*スタックフレームサイズ M とおおよそ見積もれる。
今回のケースでは再帰の深さは 100
スタックフレームサイズは、int が 4byte、ListNode が 8byte （64 ビット JVM のとき）であると見積もると、int 変数が３つ、ListNode が３つなので、4*3+8\*3=36byte くらい？
JVM のデフォルトのスタックサイズは 1MB なので、1M/36byte=27K 回くらい再帰ができるということになる。

ほかに気になったものとして以下のところで番兵（sentinel）をつかっているところがあった。しかし、番兵は条件判定処理の回数を減らすために使われるものなので、今回のケースではあまり意味がないように思えたが、あまり確証はもてませんでした。
https://github.com/YukiMichishita/LeetCode/pull/2/files
