public class FirstSolution {
    // time: O(n) nはA,Bのうちの長い方の長さ, space: O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode runnerA = headA;
        while (runnerA != null) {
            visited.add(runnerA);
            runnerA = runnerA.next;
        }
        ListNode runnerB = headB;
        while (runnerB != null) {
            if (visited.contains(runnerB)) {
                return runnerB;
            }
            runnerB = runnerB.next;
        }
        return null;
    }

    // 別解
    // time: O(n + m), space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        while (runnerA != null && runnerB != null) {
            if (runnerA != null) {
                runnerA = runnerA.next;
            }
            if (runnerB != null) {
                runnerB = runnerB.next;
            }
        }

        int diff = countDiff(runnerA != null ? runnerA : runnerB);
        if (runnerA == null) {
            return findIntersection(headA, headB, diff);
        } else {
            return findIntersection(headB, headA, diff);
        }
    }

    private int countDiff(ListNode node) {
        int diff = 0;
        while (node != null) {
            node = node.next;
            diff++;
        }
        return diff;
    }

    private ListNode findIntersection(ListNode shorter, ListNode longer, int diff) {
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (shorter != longer) {
            if (shorter == null || longer == null) {
                return null;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }
}

