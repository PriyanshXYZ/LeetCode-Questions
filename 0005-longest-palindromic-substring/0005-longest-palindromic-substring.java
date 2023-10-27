class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)return s;
        int n=s.length();
        int len=0;
        String ans="";
        for(int i=0;i<n;i++){
            String even=nextPalindrome(s,i,i+1);
            String odd=nextPalindrome(s,i,i);
            
            if(odd.length()>len){
                len=odd.length();
                ans=odd;
            }
            if(even.length()>len){
                len=even.length();
                ans=even;
            }
        }
        return ans;
    }
    
    public String nextPalindrome(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}