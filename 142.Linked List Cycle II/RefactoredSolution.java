public class RefactoredSolution {
    // time: O(n), space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findCycleStart(head, slow);
            }
        }
        return null;
    }

    private ListNode findCycleStart(ListNode slow, ListNode loopNode) {
        while (slow != loopNode) {
            slow = slow.next;
            loopNode = loopNode.next;
        }
        return slow;
    }
}
