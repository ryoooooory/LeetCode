# First Solution

自分で AC した回答。時間的には３分で計算量も考えられた。

# RefactoredByMyselfSolution

リファクタリングというよりは、別解で LinkedListCycle 同様に、Floyd アルゴリズムなるものを使いました。
前回同様に少しアルゴリズム知識がいりそうな解法だと思い、空間計算量でのメリットはあるが、Set を使った解法のがシンプルだなと思いました。
アルゴリズムとしては言語化すると、ループがあると仮定してループの長さを m, ループ以外の部分の長さを l とします。
fast,slow という進むスピードが１つ違うものを走らせるとループのなかのどこかでぶつかることになります。
slow がループに突入した地点と fast のループ地点との差は m-l となり（m > l についてはループとして考えるので mod(l, m)として考えるので問題ない）、fast と slow は１ずつループの中で近づいていくので、m-l 後にぶつかることになります。
ここで連結リストの先頭と、衝突地点は両方ループの起点から l 離れていることを利用して、リストの先頭と衝突点から Node を１つずつ進めていき同じになった時の Node を返せばループの先頭を返したことになります。

以下参考にして early return などをするようにしました。
https://discord.com/channels/1084280443945353267/1195700948786491403/1196022884888498278
https://github.com/tayzarnw/LeetCode/pull/4

# RefactoredSolution

条件式の冗長性をなくすために、While の中の少し複雑な処理を関数として外出しするようにした
参考にしたもの
https://github.com/tayzarnw/LeetCode/pull/4#issuecomment-2038618765

# RefactoredSolutionInfiniteLoop

条件式の冗長性をなくすために、無限ループを用いて変形しました！
