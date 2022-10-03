class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo=0.00;
        double hi=1.00;
        
        while(lo <= hi){
            double mid=(lo + hi)/2;
            
            int[] count=countPair(arr,mid);//count,nume,deno
            
            if(count[0] < k){
                lo=mid;
            }else if(count[0] > k){
                hi=mid;
            }else{
                return new int[]{count[1],count[2]};
            }
        }
        return null;
    }
    public int[] countPair(int[] a,double mid){
        int p=0;
        int q=1;

        int amount=0;
        int j=0;
        for(int i=0;i<a.length;i++){
            while(j<a.length && a[i]*1.0/a[j] > mid){
                j++;
            }

            if(j==a.length){
                break;
            }

            if(a[i]*1.0/a[j] > p*1.0/q){
                p=a[i];
                q=a[j];
            }
            amount+=(a.length-j);
        }
        return new int[]{amount,p,q};
    }
    
}