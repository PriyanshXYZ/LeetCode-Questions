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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(head!=null){
            if(tail==dummy || tail.val!=head.val){
                tail.next=head;
                tail=tail.next;
            }
            head=head.next;
        }
        tail.next=null;
        return dummy.next;
    }
}