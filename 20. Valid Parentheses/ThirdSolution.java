public class ThirdSolution {
    public boolean isValid(String s) {
        Stack<Character> buckets = new Stack<>();
        Map<Character, Character> bucketPairs = Map.of('(', ')', '{', '}', '[', ']');
        char[] cs = s.toCharArray();
        for (char current : cs) {
            if (bucketPairs.containsKey(current)) {
                buckets.push(current);
            } else if (buckets.isEmpty()) {
                return false;
            } else if (current != bucketPairs.get(buckets.peek())) {
                return false;
            } else {
                buckets.pop();
            }
        }
        return buckets.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> buckets = new Stack<>();
        Map<Character, Character> bucketPairs = Map.of('(', ')', '{', '}', '[', ']');
        char[] cs = s.toCharArray();
        for (char current : cs) {
            if (bucketPairs.containsKey(current)) {
                buckets.push(current);
                continue;
            }
            if (buckets.isEmpty()) {
                return false;
            }
            char closeBucket = buckets.pop();
            if (current != bucketPairs.get(closeBucket)) {
                return false;
            }
        }
        return buckets.isEmpty();
    }
}
