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
SC: O(1)
Approach - 2 Pointer
- keep adding all odd node till n (when reach last node keep link of last node to the first even node)
- keep adding all even nodes till end and return the head
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while (evenNode != null && evenNode.next != null) {

            oddNode.next = evenNode.next; // link next oddNode -> evenNode +1
            oddNode = oddNode.next; // move forward

            evenNode.next = oddNode.next; // link next evenNode -> oddNode +1
            evenNode = evenNode.next; // move forward
        }
        oddNode.next = evenHead; // link last oddNode -> first evenNode
        return head;
    }
}