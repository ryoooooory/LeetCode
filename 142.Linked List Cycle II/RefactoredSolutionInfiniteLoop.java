public class RefactoredSolutionInfiniteLoop {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode catchUp = head;
        while (slow != catchUp) {
            slow = slow.next;
            catchUp = catchUp.next;
        }
        return catchUp;
    }
}
