/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        
        if(fast==null || fast.next==null)return null;
        ListNode slow2=head;
        while(slow!=slow2){
            slow2=slow2.next;
            slow=slow.next;
        }
        return slow;
        
    }
}
class Solution1 {
    //o(n) space complexity
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet();
        while(head!=null){
            if(set.contains(head))return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
}