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
 Approach: Three pointer technique
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            ListNode nextNode = current.next; // 1. Save the next node
            current.next = prev;              // 2. Reverse the pointer
            prev = current;                   // 3. Move prev forward
            current = nextNode;               // 4. Move current forward
        }
        return prev;                           // New head of the list
        
    }
}