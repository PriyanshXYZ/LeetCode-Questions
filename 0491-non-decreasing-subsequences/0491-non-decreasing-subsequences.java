class Solution {
    
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList();
        recursion(0,nums,-101,new ArrayList());
        return res;
    }
    public void recursion(int idx, int[] nums , int prev, List<Integer> subseq){
        if(idx==nums.length){
            if(subseq.size()>1)res.add(new ArrayList(subseq));
            return;
        }
        
        if(prev<=nums[idx]){
            subseq.add(nums[idx]);
            
            recursion(idx + 1 , nums , nums[idx] ,subseq);
            
            subseq.remove(subseq.size()-1);
        }
        if(prev==nums[idx])return;
        recursion(idx + 1 , nums , prev , subseq);
    }
}