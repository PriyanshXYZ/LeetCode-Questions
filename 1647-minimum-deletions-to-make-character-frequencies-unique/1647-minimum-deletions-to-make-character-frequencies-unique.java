class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        
        Arrays.sort(freq);
        HashSet<Integer> set=new HashSet();
        int minDel=0;
        
        for(int val: freq){
            
            while(val!=0 && set.contains(val)){
                val--;
                minDel++;
            }
            set.add(val);
        }
        return minDel;
    }
}