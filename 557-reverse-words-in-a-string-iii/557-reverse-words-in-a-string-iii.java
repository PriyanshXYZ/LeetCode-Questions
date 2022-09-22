class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        s=sb.reverse().toString();
        
        String[] res=s.split(" ");
        
        int i=0,j=res.length-1;
        while(i<j){
            String temp=res[i];
            res[i]=res[j];
            res[j]=temp;
            i++;
            j--;
        }
        
        String ans=String.join(" ",res);
        return ans;
    }
}