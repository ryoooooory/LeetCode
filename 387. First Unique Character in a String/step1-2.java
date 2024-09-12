class Solution {
    // leetcode 
    public int firstUniqChar(String s) {
        int[] cs = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cs[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cs[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
