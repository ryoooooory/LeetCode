public class RefactoredSolution {
    // time: O(n), space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode collision = findCollisionPoint(head);
        if (collision == null) {
            return null;
        }
        ListNode runner = head;
        while (runner != collision) {
            collision = collision.next;
            runner = runner.next;
        }
        return runner;
    }

    private ListNode findCollisionPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
