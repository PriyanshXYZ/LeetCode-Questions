class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        Integer[] dp=new Integer[s.length()+1];
        
        return memo(0,s,dp);
    }
    public int recursion(int idx,String s){
        //base case
        if(idx==s.length())return 1;
        int ans=0;
        int ch=s.charAt(idx)-'0';
        if(ch>=1 && ch<=9){
            ans+=recursion(idx+1,s);
        }
        if(idx+2<=s.length()){
            int ch2=Integer.parseInt(s.substring(idx,idx+2));
            if(ch2>=10 && ch2<=26){
                ans+=recursion(idx+2,s);
            }
        }
        
        return ans;
    }
    public int memo(int idx,String s,Integer[] dp){
        if(idx==s.length())return 1;
        
        if(dp[idx]!=null)return dp[idx];
        int ans=0;
        int ch=s.charAt(idx)-'0';
        if(ch>=1 && ch<=9){
            ans+=memo(idx+1,s,dp);
        }
        if(idx+2<=s.length()){
            int ch2=Integer.parseInt(s.substring(idx,idx+2));
            if(ch2>=10 && ch2<=26){
                ans+=memo(idx+2,s,dp);
            }
        }
        
        return dp[idx]=ans;
    }
}