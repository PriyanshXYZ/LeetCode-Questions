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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(head!=null){
            if(!set.contains(head.val)){
                tail.next = new ListNode(head.val);
                tail = tail.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}