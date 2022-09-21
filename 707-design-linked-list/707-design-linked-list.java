class MyLinkedList {
    class Node{
        int val;
        Node next;
        
        Node(){};
        Node(int val){
            this.val=val;
        }
    }
    
    Node head;
    int size;
    public MyLinkedList() {
       head=new Node();
        size=0;
    }
    
    public int get(int index) {
        if(size==0 || index>=size){
            return -1;
        }else{
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp!=null?temp.val:-1;
        }
    }
    
    public void addAtHead(int val) {
        if(size==0){
            head.val=val;
        }else{
            Node temp=new Node(val);
            temp.next=head;
            head=temp;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        if(size==0){
            head.val=val;
        }else{
            Node temp=new Node(val);
            Node last=null;
            for(last=head;last.next!=null;last=last.next);
            last.next=temp;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }else if(index==size){
            addAtTail(val);
        }else if(index==0){
            addAtHead(val);
        }else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            Node newNode=new Node(val);
            Node ahead=temp.next;
            temp.next=newNode;
            newNode.next=ahead;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(size==0 || size<=index)return;
        else{
            if(index==0){
                head=head.next;
            }else if(index==size-1){
                Node temp=head;
                for(int i=0;i<index-1;i++){
                    temp=temp.next;
                }
                temp.next=null;
            }else{
                Node temp=head;
                for(int i=0;i<index-1;i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */