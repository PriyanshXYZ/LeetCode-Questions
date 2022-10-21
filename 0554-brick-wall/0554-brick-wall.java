class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> edgeMap=new HashMap();
        
        int gap=0;
        for(int i=0;i<wall.size();i++){
            int sum=0;
            for(int j=0;j<wall.get(i).size()-1;j++){//size - 1 as last brick k baad humesha gap hi hoga bhai
                sum+=wall.get(i).get(j);
                edgeMap.put(sum,edgeMap.getOrDefault(sum,0)+1);
                gap=Math.max(gap,edgeMap.get(sum));
            }
        }
        // System.out.println(edgeMap);
        return wall.size()-gap;
    }
}