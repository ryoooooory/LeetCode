public class RefactoredSolution {
    // time: O(n + m) nはAの長さmはBの長さ, space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        while (runnerA != runnerB) {
            runnerA = runnerA != null ? runnerA.next : headB;
            runnerB = runnerB != null ? runnerB.next : headA;
        }
        return runnerA;
    }
}
