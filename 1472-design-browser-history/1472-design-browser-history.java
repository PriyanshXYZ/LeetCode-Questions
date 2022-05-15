// using array/ll
class BrowserHistory {
    String[] history=new String[5001];
    int curr;
    int max;
    public BrowserHistory(String homepage) {
        curr=max;
        history[curr]=homepage;
    }
    
    public void visit(String url) {
        curr++;
        max=curr;//this will delete all forwrd history
        history[curr]=url;
    }
    
    public String back(int steps) {
        if(curr-steps<0){
            curr=0;
            return history[curr];
        }else{
            curr=curr-steps;
            return history[curr];
        }
    }
    
    public String forward(int steps) {
        if(curr+steps>max){
            curr=max;
            return history[curr];
        }else{
            curr=curr+steps;
            return history[curr];
        }
    }
}
//usings stack
class BrowserHistoryStk {
    Stack<String> bckwrdHistory;
    Stack<String> frwrdHistory;
    
    public BrowserHistoryStk(String homepage) {
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