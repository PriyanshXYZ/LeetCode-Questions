class Solution {
    public int maxLength(List<String> arr) {
        return recursion(0,arr.size(),"",arr);
    }
    
    public int recursion(int idx,int n,String s,List<String> a){
        if(idx==n){
            HashSet<Character> set=new HashSet();
            for(char ch:s.toCharArray()){
                if(!set.add(ch)){
                    return 0;
                }
            }
            
            return s.length();
        }
        
        int inc=recursion(idx+1,n,s+a.get(idx),a);
        
        int exc=recursion(idx+1,n,s,a);
        
        return Math.max(inc,exc);
    }
}