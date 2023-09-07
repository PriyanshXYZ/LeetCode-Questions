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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-501);
        ListNode tail = dummy;
        while(left>1){
            tail.next = head;
            head = head.next;
            tail = tail.next;
            right--;
            left--;
        }
        // System.out.println(head.val);
        
        // ListNode tail2 = listToBeReversed;
        ListNode tail2 = head;
        ListNode prev = null;
        ListNode curr = head;
        while(right>0){
            ListNode ahead = curr.next;
            curr.next = prev;;
            prev = curr;
            curr = ahead;
            right--;
        }
        tail2.next = curr;
        tail.next = prev;
        return dummy.next;
    }
}