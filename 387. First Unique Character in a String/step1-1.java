class Solution {
    // leetcode 
    public int firstUniqChar(String s) {
        Map<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indices.put(c, indices.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indices.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
