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
    public ListNode kthFromEnd(ListNode head,int k){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && --k>0){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
        
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode end=kthFromEnd(head,k);
        // System.out.println(end.val);
        ListNode kth=head;
        while(--k>0){
            kth=kth.next;
        }
        // System.out.println(kth.val);
        int temp=end.val;
        end.val=kth.val;
        kth.val=temp;
        
        return head;
    }
}