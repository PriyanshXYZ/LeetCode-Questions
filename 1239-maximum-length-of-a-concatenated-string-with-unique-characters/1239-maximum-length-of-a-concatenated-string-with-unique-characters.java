class Solution {
    public int maxLength(List<String> arr) {
        return recursion(0,arr.size(),new StringBuilder(),arr);
    }
    
   public int recursion(int idx,int n,StringBuilder sb,List<String> a){
        if(idx==n){
            HashSet<Character> set=new HashSet();
            for(char ch:sb.toString().toCharArray()){
                if(!set.add(ch)){
                    return 0;
                }
            }
            return sb.length();
        }
        sb.append(a.get(idx));
        int inc=recursion(idx+1,n,sb,a);
        int size=a.get(idx).length();
        while(size-->0){
            sb.deleteCharAt(sb.length()-1);
        }
        int exc=recursion(idx+1,n,sb,a);
        
        return Math.max(inc,exc);
    }
}