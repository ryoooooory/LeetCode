public class RefactoredByMyself {
    // time: O(n), space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode catchUp = head;
        while (slow != catchUp) {
            slow = slow.next;
            catchUp = catchUp.next;
        }
        return catchUp;
    }
}
