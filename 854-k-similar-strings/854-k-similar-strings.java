class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis=new HashSet();
        Queue<String> q=new ArrayDeque<>();
        q.add(s1);
        
        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-- >0){
                String rem=q.remove();

                if(vis.contains(rem)){
                    continue;
                }
                vis.add(rem);

                if(rem.equals(s2))return level;

                for(String s: combinations(rem,s2)){
                    if(!vis.contains(s)){
                        q.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public List<String> combinations(String s,String s2){
        List<String> res=new ArrayList();
        int idx=-1;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s2.charAt(i)){
                idx=i;
                break;
            }
        }
        if(idx!=-1){
            for(int i=idx+1;i<s.length();i++){
                if(s2.charAt(idx)==s.charAt(i)){
                    String ans=swap(s,idx,i);
                    res.add(ans);
                }
            }
        }
        return res;
    }
    public String swap(String s,int i,int j){
        StringBuilder sb=new StringBuilder(s);
        
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
        
        return sb.toString();
    }
}