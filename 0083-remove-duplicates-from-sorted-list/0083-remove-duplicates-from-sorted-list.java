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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

    

        ListNode temp = head;

        // afely check the adjacent node
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) { // current & adjacent is equal
                temp.next = temp.next.next; // link adjacent with prev node
                // = temp.next; // forward to next node
            } else {
                temp = temp.next;   // forward to next node
            }

        }
        return head;
    }
}