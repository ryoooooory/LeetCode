class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParentheses = new ArrayList<>();
        Queue<String> parenthesisCandidate = new LinkedList<>();
        Queue<Integer> unClosedleftParentheses = new LinkedList<>();
        parenthesisCandidate.add("");
        unClosedleftParentheses.add(0);

        while (!parenthesisCandidate.isEmpty()) {
            String current = parenthesisCandidate.poll();
            int currentLeftParenthesisCount = unClosedleftParentheses.poll();

            if (current.length() == 2 * n) {
                allParentheses.add(current);
                continue;
            }
            if (currentLeftParenthesisCount < 2 * n - current.length()) {
                parenthesisCandidate.add(current + "(");
                unClosedleftParentheses.add(currentLeftParenthesisCount + 1);
            }
            if (0 < currentLeftParenthesisCount) {
                parenthesisCandidate.add(current + ")");
                unClosedleftParentheses.add(currentLeftParenthesisCount - 1);
            }
        }
        return allParentheses;
    }

}
