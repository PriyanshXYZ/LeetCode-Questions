class Solution {
    public int maxLength(List<String> A) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : A) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }
}
class Solution1 {
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
