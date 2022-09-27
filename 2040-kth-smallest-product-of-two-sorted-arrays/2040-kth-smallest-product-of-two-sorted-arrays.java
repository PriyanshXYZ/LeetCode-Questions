class Solution {
    
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1=nums1.length;
        int n2=nums2.length;
        
        long lo=(long)-1e10;
        long hi=(long)1e10;
        
        while(lo<=hi){
            long val=lo+(hi-lo)/2;
            
            if(lowerThanVal(nums1,nums2,val)<k){
                lo=val+1;
            }else{
                hi=val-1;
            }
        }
        return hi;
    }
    
    public long lowerThanVal(int[] nums1,int[] nums2,long val){
        long count=0;
        for(int i:nums1){
            if(i>=0){
                int lo=0;
                int hi=nums2.length;
                while(lo<hi){
                    int mid=(lo+hi)/2;
                    
                    if((long) i*nums2[mid]<val){
                        lo=mid+1;
                    }else{
                        hi=mid;
                    }
                }
                count+=lo;
            }else{
                int lo=0;
                int hi=nums2.length;
                while(lo<hi){
                    int mid=(lo+hi)/2;
                    
                    if((long)i * nums2[mid] >= val){
                        lo=mid+1;
                    }else{
                        hi=mid;
                    }
                }
                count+=nums2.length-lo;//becuase in negative largest number will become smallest so ans would
                
            }
        }
        return count;
    }
}