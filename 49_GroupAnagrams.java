class Solution {
    // 計算量は毎回ソートが入るので、文字列の長さのmaxをl, 配列の長さをnとすると、O(l*logl * n) と予測
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedByAnagrums = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = new String(cs);
            if (map.containsKey(sorted)) {
                int index = map.get(sorted);
                groupedByAnagrums.get(index).add(str);
            } else {
                map.put(sorted, list.size());
                List<String> newList = new ArrayList<>();
                newList.add(str);
                groupedByAnagrums.add(newList);
            }
        }
        return list;
    }
}
