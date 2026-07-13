class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int remIdx = nodes.size() - n;
        if (remIdx == 0) {
            return head.next;
        }

        nodes.get(remIdx - 1).next = nodes.get(remIdx).next;
        return head;
    }
}
