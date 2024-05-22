public class FirstSolution {
    // time: O(n), space: O(n)
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> numOfValue = new HashMap<>();
        ListNode runner = head;
        while (runner != null) {
            numOfValue.put(runner.val, numOfValue.getOrDefault(runner.val, 0) + 1);
            runner = runner.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (numOfValue.get(current.next.val) > 1) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    // 別解
    // time: O(n), space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        boolean hasSameValue = false;
        while (current.next != null) {
            if (current.next.next == null) {
                if (hasSameValue) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            } else if (current.next.val == current.next.next.val) {
                current.next = current.next.next;
                hasSameValue = true;
            } else if (current.next.val != current.next.next.val && hasSameValue) {
                current.next = current.next.next;
                hasSameValue = false;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
