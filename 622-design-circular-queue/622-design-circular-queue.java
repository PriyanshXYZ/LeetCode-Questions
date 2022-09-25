class MyCircularQueue {
    int[] q;
    int front,rear;
    int k;
    int size;
    
    public MyCircularQueue(int k) {
        q=new int[k];
        this.k=k;
        size=0;
        rear=front=-1;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        rear=(rear+1)%k;
        q[rear]=value;
        // display();
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        front=(front+1)%k;
        // display();
        size--;
        return true;
        
    }
    
    public int Front() {
        if(size==0)return -1;
        return q[(front+1)%k];
    }
    
    public int Rear() {
        if(size==0)return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==k;
    }
    
    public void display(){
        for(int i=Math.max(front,0);i<=rear;i++){
            System.out.print(q[i]+" ");
        }
        System.out.println();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */