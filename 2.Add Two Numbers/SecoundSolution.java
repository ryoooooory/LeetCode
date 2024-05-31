public class SecoundSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int l1Val = l1 != null ? l1.val : 0;
        int l2Val = l2 != null ? l2.val : 0;
        int sum = l1Val + l2Val + carry;
        carry = sum / 10;
        ListNode node = new ListNode(sum % 10);
        ListNode nextL1 = l1 != null ? l1.next : null;
        ListNode nextL2 = l2 != null ? l2.next : null;
        node.next = addTwoNumbers(nextL1, nextL2, carry);
        return node;
    }
}
