class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo=0.00;
        double hi=1.00;
        
        while(lo <= hi){
            double mid=(lo + hi)/2;
            int p=0;
            int q=1;
            
            int amount=0;
            int j=0;
            for(int i=0;i<arr.length;i++){
                while(j<arr.length && arr[i]*1.0/arr[j] > mid){
                    j++;
                }
                
                if(j==arr.length){
                    break;
                }
                
                if(arr[i]*1.0/arr[j] > p*1.0/q){
                    p=arr[i];
                    q=arr[j];
                }
                amount+=(arr.length-j);
            }
            
            if(amount < k){
                lo=mid;
            }else if(amount > k){
                hi=mid;
            }else{
                return new int[]{p,q};
            }
        }
        return null;
    }
}