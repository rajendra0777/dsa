/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 TC: O(N)
 SC: O(1)
 
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return temp.next;

    }
}