public class FirstSolution {
    public boolean isValid(String s) {
        Stack<Character> openCharacters = new Stack<>();
        char[] cs = s.toCharArray();
        for (char current : cs) {
            if (openCharacters.isEmpty() || isOpenCharacter(current)) {
                openCharacters.push(current);
            } else if (isPair(openCharacters.peek(), current)) {
                openCharacters.pop();
            } else {
                return false;
            }
        }
        return openCharacters.isEmpty();
    }

    private boolean isOpenCharacter(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isPair(char left, char right) {
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
