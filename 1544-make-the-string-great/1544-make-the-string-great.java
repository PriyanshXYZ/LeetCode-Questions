class Solution {
    public String makeGood(String s) {
        Stack<Character> stk=new Stack();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(stk.size()==0)
                stk.push(s.charAt(i));
            else if(stk.size()>0 && Math.abs(stk.peek() - s.charAt(i))==32){
                    stk.pop();
            }else{
                stk.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(stk.size()>0){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}