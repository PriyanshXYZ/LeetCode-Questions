class Solution {
    public String crackSafe(int n, int k) {
        HashSet<String> visited=new HashSet();
        
        int maxComb=(int)Math.pow(k,n);
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            res.append(0);
        }
        visited.add(res.toString());
        dfs(n,k,maxComb,visited,res);
        return res.toString();
    }
    
    public boolean dfs(int n,int k,int max,HashSet<String> vis,StringBuilder res){
        if(vis.size()==max)return true;
        
        
        String used=res.substring(res.length()-(n-1));
        for(int i=0;i<k;i++){
            
            String nwpass=used+i;
            if(!vis.contains(nwpass)){
                vis.add(nwpass);
                res.append(i);

                boolean flag=dfs(n,k,max,vis,res);
                if(flag)return true;
                vis.remove(nwpass);
                res.deleteCharAt(res.length()-1);
            }
        }
        return false;
    }
}