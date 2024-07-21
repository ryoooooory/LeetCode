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

# ThirdSolution

１つめの解は、指摘通り SecondSolution の変数名を変更したもの。
別解１については、https://discord.com/channels/1084280443945353267/1195700948786491403/1197102971977211966を参考にして、以下のように考えた。
現在、車両が１列に並んでいる。車両は数字をもち小さい順に並んでいる。重複のない車両を連結していきたいが、複数人の作業を想定している。作業人は車両１台しか作業できない。
作業人のやることは以下の通り
1, 重複がみつかっているかの確認(これを重複発見状態とする)
2-1, 重複発見状態の場合は、現在みている車両の数字が重複数字と同じかを確認して、違った場合は、重複発見状態を解除してから再度同じ車両を点検する。
2-2, 重複発見状態でない場合は、次の車両を確認して重複発見状態とするかどうかを確認する。次の車両が現在の車両と違う時は素直に連結する。違わない場合は、重複発見状態とする。

別解２については、https://discord.com/channels/1084280443945353267/1195700948786491403/1197103115539841055を参考に、重複がある場合は、常に違う数字まで飛ばすことで、毎回車両のチェックの時には次の車両と現在の車両が同じ数値かどうかだけを確認すればよくなる。