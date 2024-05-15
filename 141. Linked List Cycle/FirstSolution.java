public class FirstSolution {
    // time: O(n), space: O(n)
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode runner = head;
        HashSet<ListNode> visitedNodes = new HashSet<>();
        while (runner != null) {
            if (visitedNodes.contains(runner)) {
                return true;
            }
            visitedNodes.add(runner);
            runner = runner.next;
        }
        return false;
    }
}
