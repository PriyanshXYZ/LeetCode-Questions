class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set=new TreeSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int i=0;
        Iterator value = set.iterator();
        while(value.hasNext()){
            nums[i]=(int)value.next();
            i++;
        }
        return set.size();
    }
}