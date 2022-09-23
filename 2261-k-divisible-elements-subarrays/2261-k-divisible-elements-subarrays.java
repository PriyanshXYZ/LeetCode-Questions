class Solution {
    
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> subArrSet=new HashSet();
        
        for(int si=0;si<nums.length;si++){
            String subArr="";
            int cnt=0;
            for(int ei=si;ei<nums.length;ei++){
                subArr+=nums[ei]+" ";
                if(nums[ei]%p==0)cnt++;
                
                if(cnt>k){
                    break;
                }
                subArrSet.add(subArr);
            }
        }
        // System.out.println(subArrSet);
        return subArrSet.size();
    }
}