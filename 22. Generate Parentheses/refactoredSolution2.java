class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParentheses = new ArrayList<>();
        makeCombination(n, allParentheses, new StringBuilder(), 0);
        return allParentheses;
    }

    private void makeCombination(int n, List<String> allParentheses, StringBuilder current,
            int unclosedLeftParentheses) {
        if (current.length() == 2 * n) {
            allParentheses.add(current.toString());
            return;
        }
        // 残りの挿入可能文字数が、閉じていない（の数より多い時は（を挿入
        if (unclosedLeftParentheses < 2 * n - current.length()) {
            current.append("(");
            makeCombination(n, allParentheses, current, unclosedLeftParentheses + 1);
            current.deleteCharAt(current.length() - 1);
        }
        // 閉じていない（があるので）を挿入
        if (0 < unclosedLeftParentheses) {
            current.append(")");
            makeCombination(n, allParentheses, current, unclosedLeftParentheses - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
