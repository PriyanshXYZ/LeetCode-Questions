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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode slow = head;
        ListNode fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        if(fast==null){
            //we need to remove first element of the linkedlist
            return head.next;
        }
        while(fast.next!=null){
            tail.next=slow;
            slow=slow.next;
            fast=fast.next;
            tail=tail.next;
        }
        slow.next = slow.next.next;
        tail.next = slow;
        return dummy.next;
    }
}