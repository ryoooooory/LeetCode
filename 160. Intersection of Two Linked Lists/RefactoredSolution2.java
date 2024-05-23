public class RefactoredSolution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode runnerA;
        ListNode runnerB;
        if (lengthA < lengthB) {
            runnerA = headA;
            runnerB = skipNodes(headB, lengthB - lengthA);
        } else {
            runnerA = skipNodes(headA, lengthA - lengthB);
            runnerB = headB;
        }
        while (runnerA != runnerB) {
            if (runnerA == null || runnerB == null) {
                return null;
            }
            runnerA = runnerA.next;
            runnerB = runnerB.next;
        }
        return runnerA;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    private ListNode skipNodes(ListNode node, int count) {
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        return node;
    }
}
