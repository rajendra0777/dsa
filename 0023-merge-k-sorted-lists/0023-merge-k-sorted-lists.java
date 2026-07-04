/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTemp = dummyHead;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }

        while (!queue.isEmpty()) {
            ListNode poppedNode = queue.poll();

            if (poppedNode.next != null) {
                queue.add(poppedNode.next);
            }

            dummyTemp.next = poppedNode;
            dummyTemp = dummyTemp.next;
        }

        return dummyHead.next;
    }
}