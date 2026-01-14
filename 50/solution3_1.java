/*
・概要
コメントいただいたものの反映。
leftの初期値を-1にして、rightとleftの関係をわかりやすくしたもの。
*/

public class solution3_1 {
  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int left = -1;
    int right = 0;
    Set<Character> seen = new HashSet<>();
    while (left < right && right < s.length()) {
      if (seen.contains(s.charAt(right))) {
        seen.remove(s.charAt(left + 1));
        left++;
      } else {
        seen.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left);
        right++;
      }
    }
    return maxLength;
  }
}
