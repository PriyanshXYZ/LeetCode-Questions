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
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        Deque<ListNode> stk = new ArrayDeque<>();
        
        for(ListNode node = head; node!=null; node=node.next) {
            if(stk.size()==0){
                stk.addLast(node);
            }else{
                while(stk.size()>0 && stk.peekLast().val < node.val) {
                    stk.removeLast();
                }
                stk.addLast(node);
            }
        }
        while(stk.size()>0){
            tail.next = new ListNode(stk.removeFirst().val);
            tail = tail.next;
        }
        return dummy.next;
    }
}