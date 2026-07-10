class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode first = head;
        ListNode sec = prev;

        while (sec != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = sec.next;

            first.next = sec;
            sec.next = tmp1;
            first = tmp1;
            sec = tmp2;
        }
    }
}
