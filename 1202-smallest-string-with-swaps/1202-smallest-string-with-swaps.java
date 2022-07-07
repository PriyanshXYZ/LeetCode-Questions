class Solution {
    int[] parent;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //dsu
        int n=s.length();
        parent=new int[n];
        rank=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(List<Integer> pair:pairs){
            int s1Lead=find(pair.get(0));
            int s2Lead=find(pair.get(1));
            
            if(s1Lead!=s2Lead){
                union(s1Lead,s2Lead);
            }
        }
        
        
        HashMap<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                map.put(i,new PriorityQueue());
            }
        }
        for(int i=0;i<n;i++){
            int elemPar=find(i);
            char var=s.charAt(i);
            map.get(elemPar).add(var);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int iLead=find(i);
            char ch=map.get(iLead).remove();
            sb.append(ch);
        }
        return sb.toString();
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int s1Lead,int s2Lead){
        if(rank[s1Lead]>rank[s2Lead]){
            parent[s2Lead]=s1Lead;
        }else if(rank[s2Lead]>rank[s1Lead]){
            parent[s1Lead]=s2Lead;
        }else{
            parent[s1Lead]=s2Lead;
            rank[s2Lead]++;
        }
    }
}