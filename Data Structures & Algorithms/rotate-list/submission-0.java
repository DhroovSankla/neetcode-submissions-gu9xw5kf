class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        int n = 1;
        while(cur.next != null) {
            n++;
            cur = cur.next;
        }

        cur.next = head;
        k %= n;
        for(int i = 0; i < n-k; i++) {
            cur = cur.next;
        }

        head = cur.next;
        cur.next = null;
        return head;
    }
}