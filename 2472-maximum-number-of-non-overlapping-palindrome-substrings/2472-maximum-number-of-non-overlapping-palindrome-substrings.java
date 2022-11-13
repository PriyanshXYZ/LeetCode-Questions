class Solution {
    boolean[][] palindrome;
    Integer[] dp;
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        palindrome=new boolean[s.length()+1][s.length()+1];
        palin(s);
        dp=new Integer[s.length()+1];
        return memo(0,s,k);
    }
    public int memo(int i,String s,int k){
        if(i>=s.length()){
            return 0;
        }
        if(dp[i]!=null)return dp[i];
        
        int max=0;
        int j=i+k-1;
        max=memo(i+1,s,k);
        for(;j<s.length();j++){
            int ans=0;
            if(palindrome[i][j]){
                ans=1+memo(j+1,s,k);
            }
            max=Math.max(ans,max);
        }
        return dp[i]=max;
    }
    public void palin(String s){
        int n=s.length();
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<s.length();i++,j++){
                if(gap==0){
                    palindrome[i][j]=true;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        palindrome[i][j]=true;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        palindrome[i][j]=palindrome[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                    }
                }
            }
        }
    }
    
}