class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new HashSet();
        recursion(0,nums,new ArrayList());
        return new ArrayList(res);
    }
    public void recursion(int idx, int[] nums , List<Integer> subseq){
        if(idx==nums.length)return;
        
        if(subseq.size()==0 || subseq.get(subseq.size()-1)<=nums[idx]){
            subseq.add(nums[idx]);
            if(subseq.size()>1)res.add(new ArrayList(subseq));
            recursion(idx+1,nums,subseq);
            subseq.remove(subseq.size()-1);
        }
        recursion(idx+1,nums,subseq);
    }
}