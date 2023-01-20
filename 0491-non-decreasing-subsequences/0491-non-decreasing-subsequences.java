class Solution {
    
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList();
        recursion(0,nums,new ArrayList());
        return res;
    }
    public void recursion(int idx, int[] nums , List<Integer> subseq){
        if(idx==nums.length){
            if(subseq.size()>1)res.add(new ArrayList(subseq));
            return;
        }
        
        if(subseq.size()==0 || subseq.get(subseq.size()-1)<=nums[idx]){
            subseq.add(nums[idx]);
            
            recursion(idx+1,nums,subseq);
            
            subseq.remove(subseq.size()-1);
        }
        if(idx>0 && subseq.size()>0 && subseq.get(subseq.size()-1)==nums[idx])return;
        recursion(idx+1,nums,subseq);
    }
}