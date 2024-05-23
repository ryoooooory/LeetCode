class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParentheses = new ArrayList<>();
        Queue<ParenthesisState> parenthesisCandidate = new LinkedList<>();
        parenthesisCandidate.add(new ParenthesisState("", 0));

        while (!parenthesisCandidate.isEmpty()) {
            ParenthesisState currentState = parenthesisCandidate.poll();
            String curerntString = currentState.str;
            int numCurrentUnClosedLeftParenthesis = currentState.numUnclosedLeftParenthesis;

            if (curerntString.length() == 2 * n) {
                allParentheses.add(currentState.str);
                continue;
            }
            if (numCurrentUnClosedLeftParenthesis < 2 * n - curerntString.length()) {
                parenthesisCandidate.add(new ParenthesisState(curerntString + "(",
                        numCurrentUnClosedLeftParenthesis + 1));
            }
            if (0 < numCurrentUnClosedLeftParenthesis) {
                parenthesisCandidate.add(new ParenthesisState(curerntString + ")",
                        numCurrentUnClosedLeftParenthesis - 1));
            }
        }
        return allParentheses;
    }

    class ParenthesisState {
        String str;
        int numUnclosedLeftParenthesis;

        ParenthesisState(String str, int numUnclosedLeftParenthesis) {
            this.str = str;
            this.numUnclosedLeftParenthesis = numUnclosedLeftParenthesis;
        }
    }
}
