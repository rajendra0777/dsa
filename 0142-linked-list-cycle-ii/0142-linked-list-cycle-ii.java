/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
TC : O(n)+O(n) = detect the loop + find the entrance = O(n)
SC: O(1)
Approach: Floyd's Cycle Detection Algorithm
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)return null;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode entryPointer = head; // start and wait for loop cycle detection

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) { // Cycle is detected
                
                /*
                checks if the two pointers are pointing to the same node.
                If they are different, the code enters the loop to move them */

                while (slowPointer != entryPointer) {
                    slowPointer = slowPointer.next;
                    entryPointer = entryPointer.next;
                }
                return slowPointer;
            }
        }
        return null;
    }
}