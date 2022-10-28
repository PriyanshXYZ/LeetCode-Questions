class Solution {
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