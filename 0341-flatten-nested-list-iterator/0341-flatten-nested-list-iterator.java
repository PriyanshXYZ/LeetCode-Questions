/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
        }
    }
    
    Node head;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        head=createLL(nestedList);
        
    }
    
    public Node createLL(List<NestedInteger> nestedList){
        Node dummy=new Node(0);
        Node tail=dummy;
        for(NestedInteger numList: nestedList){
            if(numList.isInteger()){
                tail.next=new Node(numList.getInteger());
                tail=tail.next;
            }else{
                tail.next=createLL(numList.getList());
                while(tail.next!=null){
                    tail=tail.next;
                }
            }
        }
        return dummy.next;
    }
    @Override
    public Integer next() {
        int val=head.data;
        head=head.next;
        return val;
    }

    @Override
    public boolean hasNext() {
        return head!=null ;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */