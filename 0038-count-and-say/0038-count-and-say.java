class Solution {
    public String countAndSay(int n) {
        return recursion(n).toString();
    }
    
    public StringBuilder recursion(int n){
        if(n==1)return new StringBuilder("1");
        
        StringBuilder prevSb=recursion(n-1);
        int idx=0;
        StringBuilder sb=new StringBuilder();
        while(idx<prevSb.length()){
            char num=prevSb.charAt(idx);
            int count=0;
            while(idx<prevSb.length() && num==prevSb.charAt(idx)){
                count++;
                idx++;
            }
            sb.append(count+""+num);
        }
        return sb;
    }
}