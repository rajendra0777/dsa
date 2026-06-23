/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
TC: O(n)
SC : O(1)
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Reverse the initial list
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 2: Filter out elements smaller than the max seen so far
        ListNode reversedHead = prev; // Remember the head of the reversed list
        ListNode maxSeen = reversedHead;
        ListNode temp = reversedHead.next; // Start from the SECOND node to avoid loops

        while (temp != null) {
            if (temp.val >= maxSeen.val) {
                maxSeen.next = temp; // Connect valid node
                maxSeen = temp; // Shift max pointer forward
            }
            temp = temp.next;
        }
        maxSeen.next = null; // Crucial: cut off any trailing smaller nodes

        // Step 3: Reverse back to original relative order
        prev = null;
        current = reversedHead; // Restart from the head of our filtered list
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}