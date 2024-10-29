class Solution {
    List<List<Integer>> lists= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0,nums,new ArrayList(), new boolean[nums.length]);
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
            vis[i] = true;
            list.add(nums[i]);
            backtrack(idx+1,nums,list,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}