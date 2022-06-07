/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> mapA=new HashMap();
        int idx=0;
        for(ListNode h1=headA;h1!=null;h1=h1.next,idx++){
            mapA.put(h1,idx);
        }
        
        for(ListNode h1=headB;h1!=null;h1=h1.next){
            if(mapA.containsKey(h1))return h1;
        }
        
        return null;
    }
}
class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for(ListNode h1=headA;h1!=null;h1=h1.next){
            for(ListNode h2=headB;h2!=null;h2=h2.next){
                if(h1==h2)return h1;
            }
        }
        return null;
    }
}