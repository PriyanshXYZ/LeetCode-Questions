class Solution {
    public String longestPrefix(String s) {
        
        int idx=getLps(s);
        if(idx==0)return "";
        return s.substring(0,idx);
    }
    
    public int getLps(String s){
        int[] lps=new int[s.length()];
        
        int i=1,len=0;
        
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
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
        
        
        return lps[s.length()-1];
    }
}