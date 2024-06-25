public class FirstSolution {
    // Time: O(n), Space: O(1), n は LinkedList の長さ
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // stack version
    // Time: O(n), Space: O(n), n は LinkedList の長さ
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> nodes = new Stack<>();
        ListNode runner = head;
        while (runner != null) {
            nodes.add(runner);
            runner = runner.next;
        }
        ListNode newHead = nodes.peek();
        while (!nodes.isEmpty()) {
            ListNode current = nodes.pop();
            current.next = nodes.isEmpty() ? null : nodes.peek();
        }
        return newHead;
    }
}
