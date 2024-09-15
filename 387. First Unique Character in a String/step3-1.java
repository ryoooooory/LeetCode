class Solution {
    // leetcode 
    private static final int NUM_ALPHABETS = 26;
    private static final char ALPHABET_OFFSET = 'a';
    public static final int NOT_FOUND = -1;

    public int firstUniqChar(String s) {
        int[] frequencies = new int[NUM_ALPHABETS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencies[c - ALPHABET_OFFSET]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequencies[c - ALPHABET_OFFSET] == 1) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
