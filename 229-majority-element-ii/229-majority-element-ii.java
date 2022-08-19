class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //naive using hashmap/freq array
        if(nums.length<=1){
            List<Integer> res=new ArrayList();
            res.add(nums[0]);
            return res;
        }
        int elem1=-1;
        int elem2=-1;
        int cnt1=0;
        int cnt2=0;
        
        for(int i=0;i<nums.length;i++){
            if(elem2==nums[i]){
                cnt2++;
            }else if(elem1==nums[i]){
                cnt1++;
            }else if(cnt2==0){
                elem2=nums[i];
                cnt2=1;
            }else if(cnt1==0){
                elem1=nums[i];
                cnt1=1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        
        cnt1=0;cnt2=0;
        for(int i=0;i<nums.length;i++){
            
            if(elem1==nums[i]){
                cnt1++;
            }else if(elem2==nums[i]){
                cnt2++;
            }
        }
        List<Integer> res=new ArrayList();
        
        if(cnt1>nums.length/3)res.add(elem1);
        
        if(cnt2>nums.length/3)res.add(elem2);
        return res;
    }
}