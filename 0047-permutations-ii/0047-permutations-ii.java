public class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0) { return ans; }
        permute(ans, nums, 0);
        return ans;
    }
    
    private void permute(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) { 
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) { temp.add(num); }
            ans.add(temp);
            return;
        }
        //we need to avoid duplicate by not using the duplicate at same level as it will produce same result
        Set<Integer> appeared = new HashSet<>();
        for (int i=index; i<nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index+1);
                swap(nums, index, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}

class Solution1 {
    //more time complexity approach..
    //we sort in this approach and do not go ahead with duplicate number which will produce unique answer
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), new boolean[nums.length]);
        return lists;
    }
    public void backtrack(int idx, int[] nums, List<Integer> list, boolean[] vis){
        //base case
        if(idx == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i])continue;
            if(i>0 &&  nums[i-1]==nums[i] && vis[i-1]==false)continue;
            vis[i] = true;
            list.add(nums[i]);
            backtrack(idx+1,nums,list,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}