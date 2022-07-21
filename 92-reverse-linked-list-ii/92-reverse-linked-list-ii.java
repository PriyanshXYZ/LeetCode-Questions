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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode lp=dummy;
        ListNode dummyPrev=null;
        for(int i=0;i<left;i++){
            dummyPrev=lp;
            lp=lp.next;
        }
        ListNode prev=null;
        ListNode start=lp;
        for(int i=0;i<=right-left;i++){
            ListNode ahead=lp.next;
            lp.next=prev;
            prev=lp;
            lp=ahead;
        }
        dummyPrev.next=prev;
        start.next=lp;
        return dummy.next;
    }
}