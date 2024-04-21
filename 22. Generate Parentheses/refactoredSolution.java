class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParentheses = new ArrayList<>();
        Queue<String> parenthesisCandidate = new LinkedList<>();
        parenthesisCandidate.add("");

        while (!parenthesisCandidate.isEmpty()) {
            String current = parenthesisCandidate.poll();
            if (!isValidParenethesisInProcess(current)) {
                continue;
            }
            if (current.length() == 2 * n) {
                if (isValidParenethesis(current)) {
                    parenthesisStrings.add(current);
                }
                continue;
            }
            parenthesisCandidate.add(current + "(");
            parenthesisCandidate.add(current + ")");
        }
        return parenthesisStrings;
    }

    private boolean isValidParenethesisInProcess(String string) {
        int notClosedleftParenethesisCount = 0;
        for (char c : string.toCharArray()) {
            if (c == '(') {
                notClosedleftParenethesisCount++;
            } else {
                notClosedleftParenethesisCount--;
            }

            if (notClosedleftParenethesisCount < 0) {
                return false;
            }
        }
        return notClosedleftParenethesisCount >= 0;
    }

    private boolean isValidParenethesis(String string) {
        int notClosedleftParenethesisCount = 0;
        for (char c : string.toCharArray()) {
            if (c == '(') {
                notClosedleftParenethesisCount++;
            } else {
                notClosedleftParenethesisCount--;
            }

            if (notClosedleftParenethesisCount < 0) {
                return false;
            }
        }
        return notClosedleftParenethesisCount == 0;
    }

}
