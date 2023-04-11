class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch!='*'){
                stk.push(ch);
            }else{
                stk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}