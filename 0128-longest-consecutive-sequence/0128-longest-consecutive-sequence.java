class Solution1 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        int maxCount=0;
        
        int prev=Integer.MIN_VALUE;
        for(int val: set){
            if(!set.contains(val-1)){
                int value=val;
                int count=1;
                while(set.contains(value+1)){
                    value+=1;
                    count+=1;
                }
                maxCount=Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
class Solution {
    //brute force o(nlogn)
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int maxCount=0;
        for(int i=0;i<n;i++){
            int currCount=1;
            int j=i;
            while(j<n-1 && Math.abs(nums[j+1]-nums[j])<=1){
                
                if(j<n-1 && (nums[j+1]-nums[j])==0){
                    j++;
                    continue;
                }
                j++;
                currCount++;
            }
            i=j;
            maxCount=Math.max(currCount,maxCount);
        }
        return maxCount;
    }
}