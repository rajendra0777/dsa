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
TC: O(N) // in case if loop not detected
SC: O(1)
Approach : slow & fast pointer
 1. start both pointers from head 
 2. slow moves by one step where fast moves by 2 steps
 3. while moving if both matching then its loop return true
 4. if fast pointer reaches last or null then return false as there is not cycle
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer)
                return true; //if both matching then its loop return true 
        }
        return false;
    }
}