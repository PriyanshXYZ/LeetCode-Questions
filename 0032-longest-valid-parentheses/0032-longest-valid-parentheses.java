class Solution {

    public int longestValidParentheses(String s) {
        Stack<Integer> stk=new Stack();
        stk.push(-1);
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stk.push(i);
            }else {
                stk.pop();
                if(stk.size()==0){
                    stk.push(i);
                }else{
                    count = Math.max(count, i - stk.peek());
                }
            }
        }
        
        return count;
    }
}