/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
TC: O(max (l1, l2))
SC: O(m+n) => extra space - currentNode
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;
        int carry = 0;

        while(temp1!=null || temp2!=null){
            
        int sum = carry;

            if(temp1!=null){
                sum+= temp1.val;
                temp1 = temp1.next; // move forward
            }

            if(temp2!=null){
                sum+= temp2.val;
                temp2 = temp2.next; // move forward
            }

            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            currentNode.next = newNode;
            currentNode = currentNode.next;
/*
            if(temp1!=null){
                temp1 = temp1.next;
            }

            if(temp2!=null){
                temp2 = temp2.next;
            }
 */           
        }
        if(carry>0){
        ListNode newNode = new ListNode(carry);
        currentNode.next = newNode;
        }
        
        return  dummyNode.next;
    }
}