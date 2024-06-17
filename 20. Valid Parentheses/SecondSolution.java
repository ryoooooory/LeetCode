public class SecondSolution {
    public boolean isValid(String s) {
        Stack<Character> buckets = new Stack<>();
        Map<Character, Character> bucketPairs = new HashMap<>();
        bucketPairs.put('(', ')');
        bucketPairs.put('{', '}');
        bucketPairs.put('[', ']');

        char[] cs = s.toCharArray();
        for (char current : cs) {
            if (bucketPairs.containsKey(current)) {
                buckets.push(current);
            } else if (buckets.isEmpty() || current != bucketPairs.get(buckets.pop())) {
                return false;
            }
        }
        return buckets.isEmpty();
    }
}
