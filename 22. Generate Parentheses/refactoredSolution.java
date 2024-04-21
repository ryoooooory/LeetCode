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
        int notClosedLeftParenethesisCount = 0;
        for (char c : string.toCharArray()) {
            if (c == '(') {
                notClosedLeftParenethesisCount++;
            } else {
                notClosedLeftParenethesisCount--;
            }

            if (notClosedLeftParenethesisCount < 0) {
                return false;
            }
        }
        return notClosedLeftParenethesisCount >= 0;
    }

    private boolean isValidParenethesis(String string) {
        int notClosedLeftParenethesisCount = 0;
        for (char c : string.toCharArray()) {
            if (c == '(') {
                notClosedLeftParenethesisCount++;
            } else {
                notClosedLeftParenethesisCount--;
            }

            if (notClosedLeftParenethesisCount < 0) {
                return false;
            }
        }
        return notClosedLeftParenethesisCount == 0;
    }

}
