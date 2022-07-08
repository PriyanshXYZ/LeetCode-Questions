class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=(s1.length()+s2.length()))return false;
        str1=s1;
        str2=s2;
        str3=s3;
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        // return recursion(0,0,0,"");
        return memo(0,0,0,"",dp);
    }
    String str1;
    String str2;
    String str3;
    
    private boolean recursion(int idx1,int idx2,int idx3,String res){
        if(idx1==str1.length() && idx2==str2.length()){
            if(res.equals(str3)){
                return true;
            }else return false;
        }
        char ch3=str3.charAt(idx3);
        boolean ans=false;
        if(idx1<str1.length()){
            char ch1=str1.charAt(idx1);
            ans|=recursion(idx1+1,idx2,idx3+1,res+ch1);
        }
        if(idx2<str2.length()){
            char ch2=str2.charAt(idx2);
            ans|=recursion(idx1,idx2+1,idx3+1,res+ch2);
        }
        return ans;
    }
    
    private boolean memo(int idx1,int idx2,int idx3,String res,int[][] dp){
        if(idx1==str1.length() && idx2==str2.length()){
            if(res.equals(str3)){
                dp[idx1][idx2]=1;
                return true;
            }else{ 
                dp[idx1][idx2]=-1;
                return false;
                 }
        }
        if(dp[idx1][idx2]!=0)return dp[idx1][idx2]==1?true:false;
        
        char ch3=str3.charAt(idx3);
        boolean ans=false;
        if(idx1<str1.length() && str1.charAt(idx1)==ch3){
            char ch1=str1.charAt(idx1);
            ans|=memo(idx1+1,idx2,idx3+1,res+ch1,dp);
        }
        if(idx2<str2.length() && str2.charAt(idx2)==ch3){
            char ch2=str2.charAt(idx2);
            ans|=memo(idx1,idx2+1,idx3+1,res+ch2,dp);
        }
        
        if(ans){
            dp[idx1][idx2]=1;
        }else{
            dp[idx1][idx2]=-1;
        }
        return ans;
    }
}