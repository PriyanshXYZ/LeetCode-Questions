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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        for(ListNode node = head; node != null; node = node.next, size++);
        
        int extra = size % k;
        int slotSize = size / k;
        
        ListNode[] res = new ListNode[k];
        int idx = 0;
        while(idx<k){
            size = slotSize + (extra>0?1:0);
            if(head==null)break;
            res[idx] = head;
            ListNode tail = head;
            while(size-- > 1){
                tail = tail.next;
            }
            
            if(tail==null)break;
            head = tail.next;
            tail.next = null;
            extra--;
            idx++;
        }
        return res;
    }
}