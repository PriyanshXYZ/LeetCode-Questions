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
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        int temp=n;
        while(fast!=null && temp-->0){
            fast=fast.next;
        }
        
        ListNode prev=null;
        while(fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=prev.next.next;
        return dummy.next;
    }
}