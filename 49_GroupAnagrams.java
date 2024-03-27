class Solution {
    // 計算量は毎回ソートが入るので、文字列の長さのmaxをl, 配列の長さをnとすると、O(l*logl * n) と予測
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedByAnagrams = new ArrayList<>();
        Map<String, Integer> sortedToGroupIndices = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = new String(cs);
            if (sortedToGroupIndices.containsKey(sorted)) {
                int groupIndex = sortedToGroupIndices.get(sorted);
                groupedByAnagrams.get(groupIndex).add(str);
            } else {
                sortedToGroupIndices.put(sorted, groupedByAnagrams.size());
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groupedByAnagrams.add(newGroup);
            }
        }
        return list;
    }
}
