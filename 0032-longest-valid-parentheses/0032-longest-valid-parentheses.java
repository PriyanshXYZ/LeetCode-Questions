class Solution {
    public int longestValidParentheses(String s) {
        Integer[] dp = new Integer[s.length()+1];
        int res =  0;
        for(int i = 0; i < s.length(); i++){
            res = Math.max(res, memo(i, s, dp));
        }
        return res;
    }
    private int memo(int idx, String s, Integer[] dp){
        if(idx < 0)return 0;
        
        if(dp[idx] != null)return dp[idx];
        
        int ans = 0;
        if(s.charAt(idx)==')'){
            if(idx > 0 && s.charAt(idx - 1) == '('){
                ans += 2;
                ans += memo(idx - 2, s, dp);
            }else if(idx > 0 && s.charAt(idx - 1) == ')'){
                int prevLen = memo(idx - 1, s, dp); // idx-1 has valid parentheses?
                if(prevLen > 0 && idx - prevLen - 1 >= 0 && s.charAt(idx- prevLen - 1) == '('){
                    ans += 2;
                    ans += prevLen;
                    ans += memo(idx - prevLen - 2, s, dp);//searching for previous answer
                }
            }
        }
        return dp[idx] = ans;
    }
}
class Solution1 {

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