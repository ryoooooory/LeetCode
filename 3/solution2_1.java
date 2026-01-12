/*
・概要
LeetCodeの回答を参考にしたもの
https://github.com/Yuto729/LeetCode_arai60/pull/3/files
https://github.com/Yuto729/LeetCode_arai60/pull/3/files#r2553158780
https://github.com/akmhmgc/arai60/pull/42/files
あーwhileの中で２こもやると難しいから、動かすものは1つだけにするのか（対象はifで分岐して）
これは結構良さそう



・解き方
solution1_2と同様だが、s = abcdc, left = 0 , right = 4みたいな時に、leftを１つずつうごかすよりcの最近出現した位置に移動したほうが高速だよねという方針。
ということで、出現文字について、indexをひもづけてMapで保存。
長さの更新については、charに紐づくindexが現在のleftより大きい時はそこに移動してもう１こ移動する必要があるが、現在のleftより小さい場合はつまり、rightとleftの間にそのcharがないことを意味するので、現在地は変えないで計算数r。

・所感
まあ、自然に考えるとsolution1_2が思い浮かんで、実装後にもっといい方法を考えるとこちらの実装に思いつくかも？という感じがいい感じだと思った。


*/

public class solution2_1 {
  public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int left = 0;
    Map<Character, Integer> seenCharAndIndex = new HashMap<Character, Integer>();

    for (int right = 0; right < s.length(); right++) {
      char current = s.charAt(right);
      if (seenCharAndIndex.containsKey(current)) {
        left = Math.max(left, seenCharAndIndex.get(current) + 1);
      }
      seenCharAndIndex.put(current, right);
      longestLength = Math.max(longestLength, right - left + 1);
    }
    return longestLength;
  }
}
