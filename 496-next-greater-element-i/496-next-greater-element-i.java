class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> ngr=new HashMap();
        Stack<Integer> stk=new Stack();
        for(int i=nums2.length-1;i>=0;i--){
            while(stk.size()>0 && nums2[stk.peek()]<=nums2[i]){
                stk.pop();
            }

            if(stk.size()!=0){
                ngr.put(nums2[i],stk.peek());
            }else{
                ngr.put(nums2[i],-1);
            }
            stk.push(i);

        }
        int[] res=new int[nums1.length];
        
        for(int i=0;i<nums1.length;i++){
            if(ngr.containsKey(nums1[i])){
                int idx=ngr.get(nums1[i]);
                res[i]=idx==-1?-1:nums2[ngr.get(nums1[i])];
            }
        }
        return res;
    }
}