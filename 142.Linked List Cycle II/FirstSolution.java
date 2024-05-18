public class FirstSolution {
    // time: O(n), space: O(n)
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode runner = head;
        HashSet<ListNode> visitedNodes = new HashSet<>();

        while (runner != null) {
            if (visitedNodes.contains(runner)) {
                return runner;
            }
            visitedNodes.add(runner);
            runner = runner.next;
        }
        return null;
    }
}
