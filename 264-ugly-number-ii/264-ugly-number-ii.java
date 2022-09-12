class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n+1];
        ugly[1]=1;
        
        int iof2=1;
        int iof3=1;
        int iof5=1;
        
        for(int i=2;i<=n;i++){
            int vof2= ugly[iof2] * 2;
            int vof3= ugly[iof3] * 3;
            int vof5= ugly[iof5] * 5;
            
            ugly[i]=Math.min(vof2,Math.min(vof3,vof5));
            
            if(ugly[i]==vof2){
                iof2++;
            }
            if(ugly[i]==vof3){
                iof3++;
            }
            if(ugly[i]==vof5){
                iof5++;
            }
        }
        
        return ugly[n];
    }
}