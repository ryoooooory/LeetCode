# 所感

自力回答のときに変数名が良くないのと、探索の時に効率化するためにはどうするか、なにがいらないのかの理解があまい気がする。
BFS,DFS の違いもなんとなくしかわかっていないので整理したい。
隣接リストを使った時と定数処理の時の速さの違い
思考の流れとしては、まず問題聞いて単純に beginWord から隣接単語を探して BFS の解法 → もう少し効率化のために隣接単語を見つけることを効率化したいなと思う → 単語同士の比較だと文字数分の計算量がかかるので、可能文字数（今回でいう小文字英単語）という制約と HashSet を使えば定数時間で隣接単語が判明することに気づけるみたいなのが理想。

# 学んだこと

## BFS

### 概要

グラフや木構造の探索に使われ最も近い Node から探索する。
具体的には根 Node からキューに加え、キューから Node を取り出しその子（隣接） Node を探索し、対象のものをキューに加えるを繰り返していく。これをキューが空になるまで繰り返す。Node の再訪問を防ぐため訪問済みの Node は保持したりする

### 計算量

時間計算量 O(N) N:グラフの辺の数
空間計算量 O(M) M:グラフの Node の数、または枝分かれの最大数

### 使用場面

一般的に最適で、最短経路を見つけるのに適する。ただ、グラフ構造が指数関数的に枝わかれするものの探索は向かない。

### 参考資料

https://ja.wikipedia.org/wiki/%E5%B9%85%E5%84%AA%E5%85%88%E6%8E%A2%E7%B4%A2

## DFS

### 概要

グラフや木構造の探索に使われ、解がみつかるまで決まった順序（木構造の場合、左 or 右）でバックトラックするまで可能な限り探索をする。
実装方法としては再帰を使うケースや Stack を使う方法がある。BFS 同様に訪問済みの Node をメモする、不要な探索を打ち切る枝刈りで効率化を図る
再帰を使ったほうが可読性は高くなる可能性が高そうだが、無限ループやスタックフレーム

### 計算量

時間計算量 O(N) N:グラフの辺の数
空間計算量 O(M) M:グラフの Node の数、または枝分かれの最大数
BFS と最悪なケースでは計算量は同じ。

### 使用場面

解が深く、Node に隣接するものが大量の場合（辺が多い）は BFS だとメモリをかなり使うことになるので、その場合は DFS のがいい。
迷路やパズルなど後ろから道順を取得みたいなとき（バックトラッキング）とかは DFS。

## スタックオーバーフロー

関数呼び出しを格納するコールスタックがいっぱいになり保存できる領域を超えてしまうこと。
関数呼び出しごとに、変数や戻りアドレスなどをまとめたスタックフレームがコールスタックに積まれていく。関数の中で関数を呼ぶ場合（サブルーチン呼び出し）、呼び出し先の引数、変数の他にフレームポインタ（呼び出し元の関数のスタックの底）、リターンアドレス（呼び出し元のアドレス）がスタックに積まれていく。
一般的な PC だとデフォルトのスタックサイズは８ MB くらい。
スタック限界について簡易的な計算をする時は、PC のスタックサイズとスタックに積まれる関数のメモリ容量を元に計算する。
一般的な PC だとスタックサイズはだいたい 8MB である。関数のメモリ容量は変数と、リターンアドレス、フレームポインタ、引数が主に確保される。変数については、型などによるがコンパイラが 16 バイトに整列させるので、最低 16 バイトは確保されるらしい。リターンアドレスとフレームポインタのメモリ量は CPU に依存し、64bitCPU なら 8 バイトとなる。

### 参考資料

https://ja.wikipedia.org/wiki/%E3%82%B3%E3%83%BC%E3%83%AB%E3%82%B9%E3%82%BF%E3%83%83%E3%82%AF
