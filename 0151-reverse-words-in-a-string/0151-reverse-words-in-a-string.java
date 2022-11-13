class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            while(i<s.length() && s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                flag=true;
                i++;
            }
            if(flag)
                sb.append(' ');
        }
        int i=sb.length()-1;
        while(sb.charAt(i)==' '){
            sb.deleteCharAt(i);
            i--;
        }
        
        i=0;
        String[] ans=sb.toString().split(" ");
        int j=ans.length-1;
        while(i<j){
            String temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",ans);
    }
}