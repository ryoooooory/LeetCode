# Step1-1
自力で回答  
解法はすぐに思いついたが途中でsplitメソッドを使う時に、＋が特殊文字だと気が付かずにエスケープをし忘れたので注意。  
解放については、基本的に問題文のとおりに処理を記述するのみ。  
時間計算量O(nm) n:配列の要素数、m:文字列の最長の長さ、  
空間計算量O(nm) 上記と同様

# Step2  
回答や他の人のPRを参考にしたもの

## Step2-1
回答を参考にした。  
Step1でStringのSplitをlocalとdomainで行っているので、無駄だなとおもっていたのをString[] partsとして解決していたのでこちらと同じようにした。  
またSplitは一致する正規表現がなければその文字列を返すので今回のケースであれば、step1のif文が不要であることに気づいた。  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/String.html

## Step2-2
回答を参考にした。   
splitを使わずに実際に処理を各文字列について走査したもの。  
Step1でも使っているが、文字列操作の時はStringよりStringBuilderを使ったほうが計算量が小さくなる。
これは文字列結合の時の例を考えると
```
String s = "Hello";
s += " World";
```
の時は、Worldをsに追加する時に新しくStringオブジェクトが生成され、そこに元のHelloとWorldが保持されるので、O(n)の計算量がかかる。
```
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
```
StringBuilderを使うと基本的にバッファが十分であればO(1)で追加が可能となり高速である。バッファが足りない時は、O(n)かかってしまう。（実装を追うと、新しい長さか元の長さの２倍の大きいほうにバッファが更新されるようだった。）  
ということで頻繁に文字列操作を行う時は特にStringBuilderのがよい。  
(ちなみに互換性があるものとしてStringBufferというものもあるが基本的にはStringBuilderが推奨されるらしい。ただ複数スレッドで文字列操作する時はスレッドセーフなStringBufferを使ったほうがいい。)  
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/StringBuilder.html

## その他
https://github.com/seal-azarashi/leetcode/pull/14/files
で議論されている通り、面接（本当は現場）だったらこの実装をどこでするのかを考慮したい。実際はDB内でのメアドのユニーク数を見るみたいなことが問題文から連想されるので、メアド登録時だったらバリデーションいるよねみたいな会話もしたい。
