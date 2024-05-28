public class SecondSolution {
    // time: O(n), space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode runner = current.next;
        while (runner != null && runner.next != null) {
            if (runner.val == runner.next.val) {
                runner = skipNodes(runner);
                current.next = runner;
            } else {
                current = runner;
                runner = runner.next;
            }
        }
        return dummy.next;
    }

    private ListNode skipNodes(ListNode node) {
        while (node.next != null && node.val == node.next.val) {
            node = node.next;
        }
        return node.next;
    }
}
