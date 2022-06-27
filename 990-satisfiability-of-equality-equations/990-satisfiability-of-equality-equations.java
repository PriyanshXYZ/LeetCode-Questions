class Solution {
    public boolean equationsPossible(String[] s) {
        
        parent=new int[26];
        rank=new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        
        //making of union
        for(int i=0;i<s.length;i++){
            if(s[i].charAt(1)=='='){
                int o1=s[i].charAt(0)-'a';
                int o2=s[i].charAt(3)-'a';
                
                int s1Lead=find(o1);
                int s2Lead=find(o2);
                
                if(s1Lead!=s2Lead){
                    union(s1Lead,s2Lead);
                }
            }
        }
        
        for(int i=0;i<s.length;i++){
            if(s[i].charAt(1)=='!'){
                int o1=s[i].charAt(0)-'a';
                int o2=s[i].charAt(3)-'a';
                
                int s1Lead=find(o1);
                int s2Lead=find(o2);
                
                if(s1Lead==s2Lead){
                    return false;
                }
            }
        }
        return true;
    }
    int[] parent;
    int[] rank;
    
    private int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int pofx=parent[x];
            parent[x]=find(pofx);
            return parent[x];
        }
    }
    
    private void union(int s1Lead,int s2Lead){
        if(rank[s1Lead]<rank[s2Lead]){
            parent[s1Lead]=s2Lead;
        }else if(rank[s1Lead]>rank[s2Lead]){
            parent[s2Lead]=s1Lead;
        }else{
            parent[s2Lead]=s1Lead;
            rank[s1Lead]++;
        }
    }
}