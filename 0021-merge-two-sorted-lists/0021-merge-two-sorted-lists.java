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

 /**
        Approach - Recursion
        T.C. O(N)
        S.C. O(L1 + L2)
  */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        
        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;


    //     ListNode head;
    //     ListNode temp;

    //     if(list1.val <= list2.val){
    //         head = temp = new ListNode(list1.val);
    //         list1 = list1.next;
    //     }else{
    //         head = temp = new ListNode(list2.val);
    //         list2 = list2.next;
    //     }

    //     while(list1 != null && list2 != null){
    //         if(list1.val < list2.val){
    //             temp.next = new ListNode(list1.val);
    //             list1 = list1.next;
    //         }else{
    //             temp.next = new ListNode(list2.val);
    //             list2 = list2.next;
    //         }
    //         temp = temp.next;
    //     }
        
    //     while(list1 != null){
    //         temp.next = new ListNode(list1.val);
    //         list1 = list1.next;
    //         temp = temp.next;
    //     }

    //      while(list2 != null){
    //         temp.next = new ListNode(list2.val);
    //         list2 = list2.next;
    //         temp = temp.next;
    //     }

    //     return head;
    }
}