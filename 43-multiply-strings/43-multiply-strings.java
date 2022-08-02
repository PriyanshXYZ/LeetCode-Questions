class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] c=new int[m+n];
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=temp+c[i+j+1];
                c[i+j+1]=sum%10;
                c[i+j]+=sum/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<c.length && c[i]==0){
            i++;
        }
        for(;i<c.length;i++){
            sb.append(c[i]);
        }
        
        return sb.length()==0?"0":sb.toString();
    }
}