class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack();
        StringBuilder res = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch==')'){
                Deque<Character> temp = new ArrayDeque<>();
                while(stk.size()>0 && stk.peek()!='('){
                    char p = stk.pop();
                    temp.push(p);
                    
                }
                stk.pop();
                while(temp.size()>0){
                    stk.push(temp.removeLast());
                }
            }else{
                stk.push(ch);
            }
        }
        while(stk.size()>0){
            res.append(stk.pop());
        }
        
        return res.reverse().toString();
    }
}