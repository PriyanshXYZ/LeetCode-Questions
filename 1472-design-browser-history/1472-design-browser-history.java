class BrowserHistory {
    Stack<String> bckwrdHistory;
    Stack<String> frwrdHistory;
    
    public BrowserHistory(String homepage) {
        bckwrdHistory=new Stack();
        frwrdHistory=new Stack();
        bckwrdHistory.push(homepage);
    }
    
    public void visit(String url) {
        frwrdHistory=new Stack();
        bckwrdHistory.push(url);
    }
    
    public String back(int steps) {
        if(steps>=bckwrdHistory.size()){
            while(bckwrdHistory.size()!=1){
                frwrdHistory.push(bckwrdHistory.pop());
            }
            return bckwrdHistory.peek();
        }else{
            while(steps-- >0){
                frwrdHistory.push(bckwrdHistory.pop());
            }
            return bckwrdHistory.peek();
        }
    }
    
    public String forward(int steps) {
        if(steps>=frwrdHistory.size()){
            while(!frwrdHistory.isEmpty()){
                bckwrdHistory.push(frwrdHistory.pop());
            }
            return bckwrdHistory.peek();
        }else{
            while(steps-- >0){
                bckwrdHistory.push(frwrdHistory.pop());
            }
            return bckwrdHistory.peek();
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */