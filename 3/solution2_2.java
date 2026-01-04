/*
・概要
https://github.com/Yuto729/LeetCode_arai60/pull/3/files
https://github.com/Yuto729/LeetCode_arai60/pull/3/files#r2553158780
https://github.com/akmhmgc/arai60/pull/42/files
あーwhileの中で２こもやると難しいから、動かすものは1つだけにするのか（対象はifで分岐して）
これは結構良さそう
ということで上記の方針でとしてみる。

・ときかた
solution1_1と似ているが、whileを２重ループにせずに状態によって、動かす方をきめて、うごかすのは１種類にする。
基本的にrightを動かしていくが、重複文字がでてきたら左を動かすモードとなる。
左を動かす時は記録から文字を消していく。

*/

public class solution2_2 {
  public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int left = 0;
    int right = 0;
    Set<Character> seen = new HashSet<Character>();

    while (right < s.length()) {
      if (seen.contains(s.charAt(right))) {
        seen.remove(s.charAt(left));
        left++;
        continue;
      }
      seen.add(s.charAt(right));
      longestLength = Math.max(longestLength, right - left + 1);
      right++;
    }
    return longestLength;
  }
}
