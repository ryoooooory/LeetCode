public class solution1_2 {
  public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int left = 0;
    Set<Character> seenChars = new HashSet<Character>();

    for (int right = 0; right < s.length(); right++) {
      char current = s.charAt(right);
      while (seenChars.contains(current)) {
        seenChars.remove(s.charAt(left));
        left++;
      }
      seenChars.add(current);
      longestLength = Math.max(longestLength, right - left + 1);
    }
    return longestLength;
  }
}
