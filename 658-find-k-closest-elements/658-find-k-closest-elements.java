class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k==arr.length){
            List<Integer> l=new ArrayList();
            for(int val:arr)l.add(val);
            return l;
        }
        
        int lo=0;
        int hi=arr.length-k;
        while(lo<hi){
            int limit=(lo+hi)/2;
            
            
            
            if(x-arr[limit]>arr[limit+k]-x){
                lo=limit+1;
            }else{
                hi=limit;
            }
        }
        
        
        List<Integer> ans=new ArrayList();
        for(int i=lo;i<lo+k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}