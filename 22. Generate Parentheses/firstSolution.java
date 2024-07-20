class Solution {
    // 再帰
    // ACだが、途中でメモ化をしてないのでかなり計算量が悪くなってTLEになった
    public List<String> generateParenthesis(int n) {
        Set<String> resultParenetheses = new HashSet<>();
        Set<String> pastState = new HashSet<>();
        insertParenetheses(n, new StringBuilder(), resultParenetheses, pastState);
        return new ArrayList<>(resultParenetheses);
    }


    private void insertParenetheses(int n, StringBuilder current, Set<String> resultParenetheses,
            Set<String> pastState) {
        if (n == 0) {
            resultParenetheses.add(new String(current));
            return;
        }
        if (pastState.contains(new String(current))) {
            return;
        }
        pastState.add(new String(current));
        for (int i = 0; i <= current.length(); i++) {
            current.insert(i, "(");
            for (int j = i + 1; j <= current.length(); j++) {
                current.insert(j, ")");
                insertParenetheses(n - 1, current, resultParenetheses, pastState);
                current.delete(j, j + 1);
            }
            current.delete(i, i + 1);
        }
    }
}
