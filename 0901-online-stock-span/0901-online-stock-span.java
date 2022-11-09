class StockSpanner {
    class Pair{
        int val;
        int days;
        
        Pair(int val,int days){
            this.val=val;
            this.days=days;
        }
    }
    Stack<Pair> stk;
    public StockSpanner() {
        stk=new Stack();
    }
    
    public int next(int price) {
        int res=1;
        while(stk.size()>0 && stk.peek().val<=price){
            res+=stk.pop().days;
        }
        stk.push(new Pair(price,res));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */