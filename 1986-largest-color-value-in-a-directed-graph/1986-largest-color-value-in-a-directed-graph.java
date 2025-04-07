class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }
        
        int[] vis = new int[n];
        int[][] cnt = new int[n][26];
        boolean[] inStck = new boolean[n];
        boolean cycle = false;
        int answer = 0;
        for(int i=0;i<n;i++){
            answer = Math.max(answer,dfs(i,colors,graph,cnt,vis,inStck));
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
    public int dfs(int node,String color,List<List<Integer>> graph, int[][] cnt, int[] vis,boolean[] inStck){
        if(vis[node]==1)return Integer.MAX_VALUE;
        
        if(vis[node]==2){
            return cnt[node][color.charAt(node)-'a'];
        }
        vis[node]=1;
        inStck[node]=true;
        
        for(int nbr : graph.get(node)){
            int ans = dfs(nbr,color,graph,cnt,vis,inStck);
            if(ans == Integer.MAX_VALUE)return Integer.MAX_VALUE;
            for(int i=0;i<26;i++){
                cnt[node][i]=Math.max(cnt[node][i],cnt[nbr][i]);
            }
        }
        vis[node]=2;
        cnt[node][color.charAt(node)-'a']++;
        inStck[node]=false;
        return cnt[node][color.charAt(node)-'a'];
        
    }
}