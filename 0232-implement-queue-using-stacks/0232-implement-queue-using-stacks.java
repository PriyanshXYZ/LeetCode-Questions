class MyQueue {
    List<Integer> stack1, stack2;
    public MyQueue() {
        stack1 = new ArrayList<>();
        stack2 = new ArrayList<>();
    }
    
    public void push(int x) {
        while(stack1.size()>0){
            stack2.add(stack1.removeLast());
        }
        stack1.add(x);
        while(stack2.size()>0){
            stack1.add(stack2.removeLast());
        }
    }
    
    public int pop() {
        return stack1.removeLast();
    }
    
    public int peek() {
        return stack1.get(stack1.size()-1);
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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