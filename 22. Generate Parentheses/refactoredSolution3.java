class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParentheses = new ArrayList<>();
        Queue<Pair<String, Integer>> parenthesisCandidate = new LinkedList<>();
        parenthesisCandidate.add(new Pair<>("", 0));

        while (!parenthesisCandidate.isEmpty()) {
            Pair<String, Integer> currentState = parenthesisCandidate.poll();
            String curerntString = currentState.getKey();
            int numCurrentUnClosedLeftParenthesis = currentState.getValue();

            if (curerntString.length() == 2 * n && numCurrentUnClosedLeftParenthesis == 0) {
                allParentheses.add(currentState.getKey());
                continue;
            }
            for (int i = 0; i <= numCurrentUnClosedLeftParenthesis + 1; i++) {
                if (2 * n < curerntString.length() + 1 + i) {
                    continue;
                }
                String closeParenthesis = ")".repeat(i);
                String nextCandidate = curerntString + "(" + closeParenthesis;
                parenthesisCandidate.add(new Pair<String, Integer>(nextCandidate,
                        numCurrentUnClosedLeftParenthesis + 1 - i));
            }
        }
        return allParentheses;
    }
}
