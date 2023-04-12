class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String[] p = path.split("/");
        for(int i=0;i<p.length;i++){
            if(stk.size()>0 && p[i].equals(".."))stk.removeLast();
            else if(!p[i].equals(".") && !p[i].equals("..") && !p[i].equals("")){
                stk.addLast(p[i]);
            }
        }
        
        if(stk.size()==0)return "/";
        while(stk.size()>0){
            sb.append('/');
            sb.append(stk.removeFirst());
            
        }
        return sb.toString();
    }
}