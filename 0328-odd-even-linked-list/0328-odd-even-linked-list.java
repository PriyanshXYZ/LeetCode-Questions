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
    public ListNode oddEvenList(ListNode head) {
        ListNode evnHead=new ListNode(-1);
        ListNode odHead=new ListNode(-1);
        ListNode evnTail=evnHead,odTail=odHead;
        while(head!=null){
            odTail.next=head;
            head=head.next;
            odTail=odTail.next;
            
            if(head!=null){
                evnTail.next=head;
                head=head.next;
                evnTail=evnTail.next;
            }
        }
        evnTail.next=null;
        
        evnHead=evnHead.next;
        odTail.next=evnHead;
        return odHead.next;
    }
}