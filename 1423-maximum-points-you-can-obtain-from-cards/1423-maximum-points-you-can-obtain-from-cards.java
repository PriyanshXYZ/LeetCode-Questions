class Solution {
    public int maxScore(int[] a, int k) {
        if(a.length==1)return a[0];
        int n=a.length;
        if(k==1){
            return Math.max(a[0],a[n-1]);
        }
        int[] prefix=new int[n];
        prefix[0]=a[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+a[i];
        }
        if(k==n)return prefix[n-1];
        int size=n-k;
        int smallestSum=prefix[size-1];
        
        int i=1;
        while(i+size-1<n){
            int currSum=prefix[i+size-1]-prefix[i-1];
            smallestSum=Math.min(smallestSum,currSum);
            
            i++;
        }
        return prefix[n-1]-smallestSum;
    }
}