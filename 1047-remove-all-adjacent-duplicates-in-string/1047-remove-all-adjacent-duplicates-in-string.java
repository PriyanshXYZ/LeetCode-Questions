class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk=new Stack();
        StringBuilder sb=new StringBuilder();
        if(s.length()<2)return s;
        int i=0;
        while(i<s.length()){
            // System.out.println(stk);
            char ch=s.charAt(i);
            if(!stk.isEmpty() && ch==stk.peek()){
                stk.pop();
            }else{
                stk.push(ch);
            }
            i++;
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}