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
        ListNode tail = dummy;
        while(head!=null){
            if(head.next==null || head.next.val!=head.val){
                tail.next=head;
                tail=tail.next;
                head=head.next;
            }else{
                ListNode curr=head;
                while(curr!=null && curr.val==head.val){
                    curr=curr.next;
                }
                head=curr;
            }
        }
        tail.next=null;
        return dummy.next;
    }
}