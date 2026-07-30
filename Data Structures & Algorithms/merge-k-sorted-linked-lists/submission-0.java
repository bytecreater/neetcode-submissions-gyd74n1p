class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode smallest = pq.poll();

            // Add smallest to answer
            temp.next = smallest;
            temp = temp.next;

            // Add next node of that list
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}