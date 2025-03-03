# Solution1

自力解法。自力では解けたが 25 分くらいかかってしまった。最初に誤って有向グラフを自分で作ろうとしたことがよくなくさらに解法自体も非効率そうだなと感じた。
時間計算量：m (m は edges の要素数)、空間計算量：m
解法としては以下のとおり
・各 Node について edges の中で繋がったものを順々に巡っていき、おとずれたのをメモしておけばよい（{0,1},{1,2}, {1,3}の場合で、Node(0)を考える場合は、繋がっているのはそれぞれ、0,2,3）
・繋がっているのものを効率よく見つけるため、Index を紐づけて HashMap で保持
・繋がっているものがあったら dfs で繋がっているものをメモしていく

# solution2_1

取り合えず LeetCode での答えを参考にして書いた。
計算量としては、O(e + v) e: edge 数、v:辺数としたほうがより正確そう（v >= e となるのは確実だが）
グラフ自体を List の配列で表すことで簡単に表現・処理を行なった。
また、https://github.com/olsen-blue/Arai60/pull/19/filesを元に
・スタックオーバーフローのチェックをするようなコメントが書いてあって、再帰の時は特に心がけないといけない（計算量見積もりの時点で癖づけたい）と感じた。
・BFS,UnionFind での解法があったので、自身も書いてみる。（UnionFind はマストではないが WANT くらいの知識らしい：https://github.com/olsen-blue/Arai60/pull/19/files）

# solution2_2

BFS 版での解法
Queue として使うと ArrayDeque の方が LinkedList より高速かつメモリ効率もいい。（https://docs.oracle.com/javase/jp/8/docs/api/java/util/ArrayDeque.html）

# solution2_3

UnionFind での解法。
そもそも UnionFind について理解できてないことが多かったのでいかにまとめる。
参考
・https://discord.com/channels/1084280443945353267/1084283898617417748/1295302973186117684）
・https://algo-method.com/descriptions/132

# solution2_4

コメントいただいたものを反映したもの。特に変数名やループ記法について修正した。

# Union find

## 概要

これはデータ構造で、グループ分けを効率的に行うもの。
このデータ構造は N 個の要素について、それぞれグループ分けを行う。
グループ分けについては、各グループはそのグループ以外のグループには属さない。
グループは木構造で管理されるので、各グループは元（根）を持つ。

## 使われる場面

## 内部構造および主要なフロー

基本的に以下のことができます。
root: ある要素の元を返す（見つける）。
isSame: ある要素について root を元に共通のグループかどうか（共通の元かどうか）を判定する。
union: 要素 A と要素 B を共通のグループとする（どちらかの元にもう片方の元を子として結合する）

## 高速化

・union by rank
unite する際に、高さが低い方のグループ（木）を高い方に結合することで、木の最大高さを O(N) → 　 O(logN)に改善できる。
これは高さ h の木を作るのに h-1 の木が 2 本必要でありこれを帰納的に考えると、2 の h 乗の木（要素）が必要となる。これによって h の木があるとき、木の高さは最大でも logh となる。

・経路圧縮
グループ内の元を返す時の効率化手法。
ある要素から親を辿っていく時に、親の要素を全て元に繋ぎ直すことで効率化を図る。

## 応用例

SNS サービスなどでグループの概念がある時に、任意の２人が同じグループに所属しているかを判定するとかに使えそう（Map などで検索するよりは高速に判定できそう）

# 学んだこと

やはりグラフの作成などよくあるお作法や一般的なデータ構造（表現）などは覚えていないとかなり時間がかかり重要な部分に取り組む時間がなくなるので、そのような部分をしっかり認識して、考えずにかけるようにしたい。
UnionFind についてはまだ慣れていないので、復習期間を多めにとって定着させたい。
ネーミングの意識が弱い＋一般的単語をまだ覚えていないので、変数名にも着目して他の人の MR を見る
