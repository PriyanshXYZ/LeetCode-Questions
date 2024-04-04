class Solution {
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int maxDepth = 0;
        int depth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stk.push(')');
                depth++;
            }else if(ch == ')'){
                if(stk.peek()==ch)stk.pop();
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}