class MyQueue {
    Stack<Integer> mainstk=new Stack();
    Stack<Integer> stk=new Stack();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(mainstk.size()==0) mainstk.push(x);
        else{
            while(mainstk.size()>0){
                stk.push(mainstk.pop());
            }
            mainstk.push(x);
            while(stk.size()>0){
                mainstk.push(stk.pop());
            }
        }
    }
    
    public int pop() {
        return mainstk.pop();
    }
    
    public int peek() {
        return mainstk.peek();
    }
    
    public boolean empty() {
        return mainstk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */