public class ThirdSolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummy;
        prev.next = current;
        while (current != null) {
            if (current.next == null || current.next.val != current.val) {
                prev.next = current;
                prev = current;
                current = current.next;
            } else {
                current = skipNode(current);
                prev.next = current;
            }
        }
        return dummy.next;
    }

    private ListNode skipNode(ListNode node) {
        while (node.next != null && node.val == node.next.val) {
            node = node.next;
        }
        return node.next;
    }

    // 別解1
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummy;
        prev.next = current;

        boolean hasRepeat = false;
        int repeatValue = -1;

        while (current != null) {
            if (hasRepeat) { // 重複がすでに確認されている
                prev.next = current.next;
                if (current.val != repeatValue) { // あたらしい数字に切り替わったので、この数字からまた判定を再開する
                    hasRepeat = false;
                    continue;
                }
            } else if (current.next == null) { // 最後の要素でかつ、重複は見つかってないので、連結する
                prev.next = current;
            } else {
                if (current.val == current.next.val) { // 重複が見つかったのでフラグと値を更新
                    hasRepeat = true;
                    repeatValue = current.val;
                } else { // 重複ないので、素直に連結
                    prev.next = current;
                    prev = current;
                }
            }
            current = current.next;
        }
        return dummy.next;
    }

    // 別解2
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummy;
        prev.next = current;

        while (current != null) {
            if (current.next == null || current.val != current.next.val) {
                prev.next = current;
                prev = current;
                current = current.next;
                continue;
            }
            int repeatValue = current.val;
            while (current != null && current.val == repeatValue) {
                current = current.next;
            }
            prev.next = current;
        }
        return dummy.next;
    }

}
