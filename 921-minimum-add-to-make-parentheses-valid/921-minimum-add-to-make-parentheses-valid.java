class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk=new Stack();
        
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(stk.size()>0 && stk.peek()=='('){
                    stk.pop();
                }else{
                    stk.push(ch);
                }
            }else{
                stk.push(ch);
            }
        }
        return stk.size();
    }
}
class Solution1 {
    public int minAddToMakeValid(String s) {
        int open=0,close=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else{
                if(open==0) close++;
                else open--;
            }
        }
        return open+close;
    }
}
