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
    public ListNode partition(ListNode head, int x) {
        ListNode less=new ListNode(0);
        ListNode more=new ListNode(0);
        ListNode lessTail=less;
        ListNode moreTail=more;
        for(;head!=null;head=head.next){
            if(head.val<x){
                lessTail.next=head;
                lessTail=lessTail.next;
            }else{
                moreTail.next=head;
                moreTail=moreTail.next;
            }
        }
        moreTail.next=null;
        lessTail.next=more.next;
        
        return less.next;
    }
}