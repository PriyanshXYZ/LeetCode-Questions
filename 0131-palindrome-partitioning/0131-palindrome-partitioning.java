class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
class Solution1 {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList();
        dfs(s,new ArrayList(),res);
        return res;
    }
    
    public void dfs(String s,List<String> set,List<List<String>> res){
        if(s.length()==0 || s==null){
            res.add(new ArrayList<>(set));
            return ;
        }
        
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if(!isPalindrome(temp))continue;
            
            set.add(temp);
            dfs(s.substring(i),set,res);
            set.remove(set.size()-1);
        }
        return;
    }
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
