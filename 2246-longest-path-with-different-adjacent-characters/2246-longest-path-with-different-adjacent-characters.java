class Solution {
    int maxLen = 1;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) graph.add(new ArrayList<>());
        
        for(int i = 1 ; i < parent.length; i++){
            int u = parent[i];
            
            graph.get(u).add(i);
        }
        
        dfs(0, graph, s);
        return maxLen;
    }
    public int dfs(int src, List<List<Integer>> graph, String s){
        //base case
        if(graph.get(src).size()==0){
            // System.out.println(src+" leaf");
           return 1;
        }
        
        int longestPath = 0, secondLongestPath = 0;
        for(int nbr : graph.get(src)){
            int longestChildPath = dfs(nbr, graph, s);
            // System.out.println(nbr +" child path "+longestChildPath);
            if(s.charAt(src) == s.charAt(nbr))continue;//skip this child
            
            if(longestChildPath > longestPath){
                secondLongestPath = longestPath;
                longestPath = longestChildPath;
            }else if(longestChildPath > secondLongestPath){
                secondLongestPath = longestChildPath;
            }
        }
        // System.out.println(src+"=>"+longestPath+","+secondLongestPath);
        int path = longestPath + secondLongestPath + 1;
        maxLen = Math.max(path , maxLen);
        return longestPath + 1;
    }
}