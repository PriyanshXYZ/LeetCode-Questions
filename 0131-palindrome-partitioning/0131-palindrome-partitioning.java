class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
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
