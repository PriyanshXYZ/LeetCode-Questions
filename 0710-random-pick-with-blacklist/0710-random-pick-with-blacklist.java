class Solution {
    Map<Integer,Integer> map;
    Set<Integer> nums;
    Random r;
    int lim;
    public Solution(int n, int[] blacklist) { 
        nums=new HashSet();
        map=new HashMap();
        lim=n-blacklist.length;

        for(int val:blacklist){
            nums.add(val);
        }
        
        int curr=lim;
        for(int bl:blacklist){
            if(bl<lim){
                while(nums.contains(curr)){
                    curr++;
                }
                map.put(bl,curr);
                curr++;
            }
        }
        r=new Random();
    }
    
    public int pick() {
        int num=r.nextInt(lim);
        if(map.containsKey(num)){
            num = map.get(num);
        }
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */