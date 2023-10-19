class Solution {
    public String solve(Stack<Character> stk,String str){
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!='#'){
                stk.push(ch);
            }else{
                if(!stk.isEmpty())stk.pop();
            }
        }
        String ans="";
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1=new Stack();
        Stack<Character> t1=new Stack();
        
        String a=solve(s1,s);
        String b=solve(t1,t);
        return a.equals(b);
    }
}