public class RefactoredSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashSet特有の操作をするわけではなく将来的なSetの変更も容易となる点と、コードを読む人が具体的な実装を意識する必要をなくすためにSetとする
        Set<ListNode> visited = new HashSet<>();
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        // listA, listBどちらかがnull(端)になるまで、すすめる。
        while (runnerA != null && runnerB != null) {
            if (runnerA != null) {
                runnerA = runnerA.next;
            }
            if (runnerB != null) {
                runnerB = runnerB.next;
            }
        }
        ListNode shorter;
        ListNode longer;
        int diff;
        // null(端)になってないlistについて残りの長さを取得する。
        if (runnerA == null) {
            shorter = headA;
            longer = headB;
            diff = getLength(runnerB);
        } else {
            shorter = headB;
            longer = headA;
            diff = getLength(runnerA);
        }

        // 計測した長さだけ長い方のlistを先頭から進めた後に、両方のlistを一致確認しながらすすめていき、衝突点を見つける。
        return skipNodesAndGetCommonNode(shorter, longer, diff);
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    private ListNode skipNodesAndGetCommonNode(ListNode shorter, ListNode longer, int diff) {
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (shorter != null && longer != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }
}
