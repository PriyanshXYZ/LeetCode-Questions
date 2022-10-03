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
class Solution{
    
    public ListNode reverseList(ListNode head) {
        l=head;
        reverseDI(head);
        return head;
    }
    ListNode l;
    boolean work=true;
    public void reverseDI(ListNode r){
        if(r==null)return;
        
        reverseDI(r.next);
        
        if(work==true){
            if(l==r || l.next==r){
                work=false;
            }
            
            int temp=l.val;
            l.val=r.val;
            r.val=temp;
            l=l.next;
        }
    }
}
class Solution1{
    ListNode tail=null;
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        reversePR(curr);
        curr.next=null;
        return tail;
    }
    public ListNode reversePI(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
    public ListNode reversePR(ListNode head){
        if(head.next==null) return head;
        tail=head.next;
        //faith
        reversePR(head.next);
        head.next.next=head;
        return head;
    }
    
}