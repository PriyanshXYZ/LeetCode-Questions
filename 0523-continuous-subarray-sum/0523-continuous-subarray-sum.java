class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0]%k;
        for(int i=1;i<nums.length;i++){
            prefix[i]=(prefix[i-1]+nums[i]);
        }
        
        HashMap<Integer,Integer> map=new HashMap();
        map.put(0,-1); //put this as if there exist a subarray from start ,we should be able to find it .. eg. 23, 2, 4, 6 ,6
        for(int i=0;i<nums.length;i++){
            int rem=prefix[i]%k;
            if(!map.containsKey(rem)){
                map.put(rem,i);    
            }else if((i-map.get(rem))>1)return true;
            
        }
        return false;
    }
}

class Solution1 {
    //o(n^2)
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+2;j<nums.length;j++){
                if((prefix[j]-prefix[i])%k==0){
                    return true;
                }
            }
        }
        return false;
    }
}