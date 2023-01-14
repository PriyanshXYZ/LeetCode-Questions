class Solution {
    class UF{
        int[] parent;
        int[] rank;
        
        UF(){
            parent = new int[26];
            rank = new int[26];
            for(int i =0;i<26;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                return parent[x]=find(parent[x]);
            }
            return x;
        }
        void union(int x,int y){
            int xlead = find(x);
            int ylead = find(y);
            
            
            if(xlead!=ylead){
                // if(rank[xlead]>rank[ylead]){
                //     parent[ylead]=xlead;
                // }else if(rank[xlead]<rank[ylead]){
                //     parent[xlead]=ylead;
                // }else{
                    if(xlead<ylead){
                        parent[ylead]=xlead;
                        rank[xlead]++;
                    }else{
                        parent[xlead]=ylead;
                        rank[ylead]++;
                    }
                // }
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UF uf = new UF();
        for(int i = 0;i<n;i++){
            uf.union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        
        String res = "";
        for(int i = 0; i<baseStr.length();i++){
            int ch = baseStr.charAt(i)-'a';
            res+=(char)(uf.find(ch)+'a');
        }
        return res;
    }
}