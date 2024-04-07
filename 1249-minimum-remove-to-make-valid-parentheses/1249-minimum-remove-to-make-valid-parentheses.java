class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch!='(' && ch!=')'){
                sb.append(ch);
            }else{
                if(ch=='('){
                    sb.append(ch);
                    stk.push(sb.length()-1);
                }else{
                    if(!stk.isEmpty()){
                        stk.pop();  
                        sb.append(ch);
                    }
                }
            }
            
        }
        while(!stk.isEmpty()){
            sb.deleteCharAt(stk.pop());
        }
        return sb.toString();
    }
}