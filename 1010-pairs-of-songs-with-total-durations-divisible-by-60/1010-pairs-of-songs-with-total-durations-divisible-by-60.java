class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fmap=new int[60];
        int count=0;
        for(int i=0;i<time.length;i++){
            int val=time[i]%60;
            
            if(val==0){
                count+=fmap[val];
            }else{
                count+=fmap[60-val];
            }
            fmap[val]++;
        }
        return count;
    }
}
//with hashmap
class Solution1 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map=new HashMap();
        int count=0;
        for(int i=0;i<time.length;i++){
            if(time[i]%60==0){
                if(map.containsKey(0))
                    count+=map.get(0);    
            }else{
                if(map.containsKey(60-time[i]%60))
                    count+=map.get(60-time[i]%60);
            }
            map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        }
        
        return count;
    }
}