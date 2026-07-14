class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        int n = arr.size();
        k %= n;
        cur = head;
        for (int i = n-k; i < n; i++) {
            cur.val = arr.get(i);
            cur = cur.next;
        }
        for (int i = 0; i < n-k; i++) {
            cur.val = arr.get(i);
            cur = cur.next;
        }
        return head;
    }
}