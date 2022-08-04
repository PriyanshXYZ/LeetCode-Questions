class Solution {
    HashMap<String,PriorityQueue<String>> graph;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph=new HashMap();
        
        //creating graph
        for(List<String> t: tickets ){
            String arr=t.get(0);
            String dep=t.get(1);
            if(!graph.containsKey(arr)){
                graph.put(arr,new PriorityQueue());
            }
            graph.get(arr).add(dep);
        }
        System.out.println(graph);
        List<String> res=new ArrayList();
        dfs("JFK",res);
        return res;
    }
    
    private void dfs(String s,List<String> ans){
        if(!graph.containsKey(s) ||graph.get(s).size()==0){
            ans.add(0,s);
            return;
        }
        while(graph.get(s).size()>0){
            String nbr=graph.get(s).remove();
            dfs(nbr,ans);
        }
        ans.add(0,s);
    }
}