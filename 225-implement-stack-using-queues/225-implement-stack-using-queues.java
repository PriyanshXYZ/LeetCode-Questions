class MyStack {
    Queue<Integer> q=new ArrayDeque();
    Queue<Integer> aux=new ArrayDeque();
    int top=-1;
   
    public void push(int x) {
        if(!q.isEmpty()){
            aux.add(x);
            while(!q.isEmpty()){
                
                aux.add(q.remove());
            }
            while(!aux.isEmpty()){
                q.add(aux.remove());
            }
        }else{
            q.add(x);
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
        
    }
    
    public boolean empty() {
        if(q.isEmpty())return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */