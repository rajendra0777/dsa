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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)return head;

        int length = 1;
        ListNode lastNode = head;

        // count length of node
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }

        lastNode.next = head; // create temp circular node

        k = k % length;
        int traverseCount = length - k;

        ListNode nextNode = head;
        
        // traverse upto length - k
        for (int i = 1; i < traverseCount; i++) {
            nextNode = nextNode.next;
        }
        // break node after length - k
        ListNode newHead = nextNode.next;
        nextNode.next = null;
       // head = newHead;
        return newHead;
    }

}