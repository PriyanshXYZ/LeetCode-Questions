class Solution {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length();
        if(n==1)return "";
        
        StringBuilder sb=new StringBuilder(palindrome);
        for(int i=0;i<n/2;i++){
            if(sb.charAt(i)!='a'){
                sb.setCharAt(i,'a');
                return sb.toString();
            }
        }
        
        if(sb.charAt(n-1)!='a')
            sb.setCharAt(n-1,'a');
        else{
            sb.setCharAt(n-1,'b');
        }
        return sb.toString();
    }
}