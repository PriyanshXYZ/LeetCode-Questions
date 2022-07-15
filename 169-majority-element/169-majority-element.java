class Solution {
    public int majorityElement(int[] a) {
        Integer majEle=null;
        int count=0;
        for(int i=0;i<a.length;i++){
            if(count==0){
                majEle=a[i];
                count++;
            }else if(majEle==a[i]){
                count++;
            }else{
                count--;
            }
        }
        return majEle;
    }
}
//with space
class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
}