class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,int[]> map=new HashMap();
        for(int[] match:matches){
            int winner=match[0];
            int loser=match[1];
            if(!map.containsKey(winner)){
                map.put(winner,new int[2]);
            }
            if(!map.containsKey(loser)){
                map.put(loser,new int[2]);
            }
            map.get(winner)[0]++;
            map.get(loser)[1]++;
        }
        
        List<List<Integer>> ans=new ArrayList();
        ans.add(new ArrayList());
        ans.add(new ArrayList());
        for(int val:map.keySet()){
            if(map.get(val)[1]==0){
                ans.get(0).add(val);
            }
            if(map.get(val)[1]==1){
                ans.get(1).add(val);
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}