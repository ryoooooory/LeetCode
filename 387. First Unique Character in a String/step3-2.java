class Solution {
    // leetcode 
    public int firstUniqChar(String s) {
        Map<Character, Integer> characterToFrequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characterToFrequencies.put(c, characterToFrequencies.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterToFrequencies.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
