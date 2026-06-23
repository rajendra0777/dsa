/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } 4,5,1,9
 */ 
class Solution {
    public void deleteNode(ListNode node) {
      if(node == null || node.next==null) return;

      node.val = node.next.val; // copy next node val to prev
      node.next = node.next.next; // copy next node add to prev
        
    }
}