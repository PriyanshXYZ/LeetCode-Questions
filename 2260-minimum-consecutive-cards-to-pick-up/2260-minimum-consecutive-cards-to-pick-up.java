class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap();
        
        int distance=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                distance=Math.min(distance,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return distance==Integer.MAX_VALUE?-1:distance;
    }
}