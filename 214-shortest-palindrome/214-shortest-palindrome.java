class Solution {
    //kmp algorithm
    public String shortestPalindrome(String s) {
        String res=s+'$'+new StringBuilder(s).reverse();
        int[] lps=new int[res.length()];
        lps[0]=0;
        int len=0,i=1;;
        while(i<res.length()){
            if(res.charAt(i)==res.charAt(len)){
                lps[i]=len+1;
                len++;
                i++;
            }else if(len==0){
                lps[i]=0;
                len=0;
                i++;
            }else{
                len=lps[len-1];
            }
        }
        return new StringBuilder(s.substring(lps[lps.length-1])).reverse()+s;
    }
}