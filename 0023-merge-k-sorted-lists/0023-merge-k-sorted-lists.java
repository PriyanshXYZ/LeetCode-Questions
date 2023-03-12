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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return mergeSort(lists,0,lists.length - 1);
    }
    public ListNode mergeSort(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        
        int mid = (l + r) / 2;
        
        ListNode left = mergeSort(lists, l, mid);
        ListNode right = mergeSort(lists, mid + 1, r);
        return merge2List(left,right);
    }
    
    public ListNode merge2List(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode tail = res; 
        
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }
        }
        
        while(l1!=null){
            tail.next = new ListNode(l1.val);
            tail = tail.next;
            l1 = l1.next;
        }
        
        while(l2!=null){
            tail.next = new ListNode(l2.val);
            tail = tail.next;
            l2 = l2.next;
        }
        return res.next;
    }
}