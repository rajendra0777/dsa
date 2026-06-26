/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 TC: O(n/2)
 SC: O(1)
 Approach : Slow, Fast Pointer approach
  */
class Solution {
    public ListNode middleNode(ListNode head) {
         if (head == null)return head;

            /*
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        
        int mid = count / 2;
        temp = head;
        while (mid > 0) {
            temp = temp.next;
            mid--;
            }
        */

        ListNode slowPointer = head;
        ListNode fastPointer = head; // Start both at head

        // handles even, odd list lengths
        while (fastPointer!= null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;         // moves 1 step
            fastPointer = fastPointer.next.next;    // moves 2 steps 
        }
        return slowPointer;
    }
}