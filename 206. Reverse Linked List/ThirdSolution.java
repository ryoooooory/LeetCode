public class ThirdSolution {
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(null, head);
    }

    private ListNode reverseListHelper(ListNode prev, ListNode current) {
        if (current == null) {
            return prev;
        }
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        return reverseListHelper(prev, current);
    }


    // 別の再帰の書き方
    // Time: O(n), Space: O(n), n は LinkedList の長さ
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head);
    }

    private ListNode reverseListHelper(ListNode current) {
        if (current == null) {
            return null;
        }
        if (current.next == null) {
            return current;
        }

        ListNode next = current.next;
        ListNode head = reverseListHelper(next);
        next.next = current;
        current.next = null;
        return head;
    }

}
