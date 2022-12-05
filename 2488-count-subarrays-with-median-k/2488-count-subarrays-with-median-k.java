class Solution {
    public int countSubarrays(int[] nums, int k) {
        int kIdx=-1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                kIdx=i;
                break;
            }
        }
        int subArr=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=kIdx,bal=0;i<nums.length;i++){
            bal+=nums[i]==k?0:nums[i]<k?-1:1;
            map.put(bal,map.getOrDefault(bal,0)+1);
        }
        for(int i=kIdx,bal=0;i>=0;i--){
            bal+=nums[i]==k?0:nums[i]<k?-1:1;
            subArr+=map.getOrDefault(-bal,0)+map.getOrDefault(-bal+1,0);
        }
        return subArr;
    }
}