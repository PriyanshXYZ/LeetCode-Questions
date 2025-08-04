class Solution {
    public int totalFruit(int[] fruits) {
        int maxLen=0;
        Map<Integer,Integer> map=new HashMap();
        int si=0;
        for(int ei=0;ei<fruits.length;ei++){
            int val=fruits[ei];
            map.put(val,map.getOrDefault(val,0)+1);
            
            while(map.size()==3){
                map.put(fruits[si],map.get(fruits[si])-1);
                if(map.get(fruits[si])==0)map.remove(fruits[si]);
                si++;
            }
            maxLen=Math.max(ei-si+1,maxLen);
        }
        return maxLen;
    }
}