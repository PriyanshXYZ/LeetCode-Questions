class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> dot = new Stack<>();
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stk.push(idx);
            }else if(ch=='*'){
                dot.push(idx);
            }else{
                if(!stk.isEmpty())stk.pop();
                else if(!dot.isEmpty())dot.pop();
                else return false;
            }
            idx++;
        }
        
        while(!stk.isEmpty()){
            if(dot.isEmpty())return false;
            if(dot.peek()>stk.peek()){
                stk.pop();
                dot.pop();
            }else return false;
        }
        return true;
    }
}