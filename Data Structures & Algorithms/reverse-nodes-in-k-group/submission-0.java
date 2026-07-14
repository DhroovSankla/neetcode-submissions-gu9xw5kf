class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode check = head;
        for (int i = 0; i < k; i++) {
            if (check == null) return head;
            check = check.next;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        
        return prev;
    }
}
