class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int count=0;
        while(i<j){
            
            if(nums[i]+nums[j]==k){
                count++;
                i++;
                j--;
            }else if(nums[i]+nums[j]>k){
                j--;
            }else if(nums[i]+nums[j]<k){
                i++;
            }
        }
        return count;
    }
}
    
    // @timecomplexity //O(Nlogn)
//     public int maxOperations(int[] nums, int k) {
//         List<Integer> list=new ArrayList();
//         for(int num:nums){
//             list.add(num);
//         }
//         Collections.sort(list);
        
//         int i=0,j=list.size()-1;
//         int count=0;
//         while(i<j){
//             if(list.get(i)+list.get(j)==k){
//                 list.remove(j);
//                 list.remove(i);
//                 count++;
//                 i=0;
//                 j=list.size()-1;
//             }else if(list.get(i)+list.get(j)>k){
//                 j--;
//             }else if(list.get(i)+list.get(j)<k){
//                 i++;
//             }
//         }
//         return count;
//     }
