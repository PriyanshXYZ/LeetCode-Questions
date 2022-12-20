class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        backtracking(new StringBuilder(),0,0,n);
        return res;
    }
    public void backtracking(StringBuilder sb, int open, int close, int n){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        
        if(open < n){
            sb.append('(');
            backtracking(sb,open + 1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(')');
            backtracking(sb,open, close + 1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}