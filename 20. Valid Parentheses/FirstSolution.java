public class FirstSolution {
    public boolean isValid(String s) {
        Stack<Character> opanCharacters = new Stack<>();
        char[] cs = s.toCharArray();
        for (char current : cs) {
            if (opanCharacters.isEmpty() || isOpenCharacter(current)) {
                opanCharacters.push(current);
            } else if (isPare(opanCharacters.peek(), current)) {
                opanCharacters.pop();
            } else {
                return false;
            }
        }
        return opanCharacters.isEmpty();
    }

    private boolean isOpenCharacter(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean isPare(char left, char right) {
        boolean result;
        switch (left) {
            case '(':
                result = right == ')';
                break;
            case '{':
                result = right == '}';
                break;
            case '[':
                result = right == ']';
                break;
            default:
                result = false;
        }
        return result;
    }
}
