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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        ListNode curr=head;
        if(curr==null)return null;
        if(curr.next==null)return curr;
        while(curr!=null && curr.next!=null){
            
            ListNode ahead=curr.next;
            ListNode go=ahead.next;
            tail.next=ahead;
            ahead.next=curr;
            tail=curr;
            curr.next=go;
            curr=go;
        }
        
        
        return dummy.next;
    }
}