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
    public ListNode swapPairs(ListNode head){
        return swapPairsRecur(head);
    }
    public ListNode swapPairsIter(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        ListNode curr=head;
        //ITERATIVE SOLUTION time complexity O(N) and space complexity O(1)
        if(curr==null || curr.next==null)return curr;
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
    //Recursive Time complexity O(N) and Space complexity of stack O(N)
    public ListNode swapPairsRecur(ListNode head){
        if(head==null || head.next==null)return head;
        
        ListNode ahead=head.next;
        head.next=swapPairsRecur(head.next.next);
        ahead.next=head;
        return ahead;
    }
}