class Solution {
    // leetcode 
    private static final int ALPHABET_SIZE = 26;
    private static final char ALPHABET_OFFSET = 'a';
    public static final int NOT_FOUND = -1;

    public int firstUniqChar(String s) {
        int[] frequency = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[c - ALPHABET_OFFSET]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequency[c - ALPHABET_OFFSET] == 1) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
