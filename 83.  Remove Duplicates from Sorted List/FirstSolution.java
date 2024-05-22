public class FirstSolution {
    // time: O(n), space: O(n)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> values = new HashSet<>();
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            values.add(runner.val);
            if (values.contains(runner.next.val)) {
                ListNode nextCandidate = runner.next;
                while (nextCandidate != null && values.contains(nextCandidate.val)) {
                    nextCandidate = nextCandidate.next;
                }
                runner.next = nextCandidate;
            }
            runner = runner.next;
        }
        return head;
    }

    // time: O(n), space: O(1) 別解
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode candidate = head;
        while (candidate != null) {
            candidate = current.next;
            while (candidate != null && candidate.val == current.val) {
                candidate = candidate.next;
            }
            current.next = candidate;
            current = candidate;
        }
        return head;
    }
}
