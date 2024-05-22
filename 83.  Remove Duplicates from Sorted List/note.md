# FirstSolution

解法はすぐに思いついて５分くらいで実装できた。計算量もわかった。
Set を使わない別解方がわかりやすく自然だと思った。

# SecondSolution

https://github.com/SuperHotDogCat/coding-interview/pull/20/files
を参考にした。FirstSolution の別解をさらによく考え、そもそも next を都度更新していけばよいので、変数も削減しよりシンプルになった。
あとからみたがhttps://github.com/nittoco/leetcode/pull/8/commits/12632e16c2697d0c14f3826c812395354f5a2068でも同様だった。

# ThirdSolution

コメントいただき、２重ループせずとも while の中で if 分岐するだけで期待値をみたせることに気づけた。SecondSolution の方はより実装方針としては直感的だが２重ループとなるので可読性が悪い。
ThirdSolution の方は、while の中で次の Node をきめることと、Node の現在地を更新することの２種類あるので、少し慣れがいるが、可読性が高くネストも少ないのでよい。
