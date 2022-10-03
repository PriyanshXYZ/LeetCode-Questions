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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;
        
        l=head;
        f(head);
    }
    ListNode l;
    boolean work=true;
    public void f(ListNode r){
        if(r==null)return;
        
        f(r.next);
        
        if(work==true){
            if(l!=r && l.next!=r){
                ListNode ahead=l.next;
                l.next=r;
                r.next=ahead;
                l=ahead;
            }else{
                r.next=null;
                work=false;
            }
        }
    }
}