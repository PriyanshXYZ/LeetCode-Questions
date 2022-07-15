class Solution {
    public int majorityElement(int[] a) {
        int majEle=a[0];
        int freq=1;
        for(int i=1;i<a.length;i++){
            if(a[i]==majEle){
                freq++;
            }else{
                if(freq>0){
                    freq--;
                }else{
                    majEle=a[i];
                    freq=1;
                }
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