# FirstSolution

7 分ほどで最初の解法はとおせたが、while の処理に時間がかかった。
別解については、重複がすでに確認されているときと、連続しているときという２観点で分岐をしていたがミスも多くどこか不自然さを感じた。

# SecondSolution

https://github.com/fhiyo/leetcode/pull/4/files
https://github.com/TORUS0818/leetcode/pull/6/files
を参考にして、重複があった時は skip するだけでロジック的にもコード的にもスッキリすることに気づけた。
current: 重複がないことが確定している現在地
runner: current の次になりそうなもの。重複があった場合は、その要素を全部とばす。
ステップ的には重複ないこと確定 →current の位置が更新ということを念頭におけば難しくない
