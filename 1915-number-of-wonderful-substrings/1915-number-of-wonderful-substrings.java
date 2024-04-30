class Solution {
    public long wonderfulSubstrings(String word) {
        int[] freq = new int[1024];//or can use hashmap
        freq[0]=1;
        long ans = 0;
        int mask = 0;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            mask ^= (1<<(ch-'a'));
            
            ans += freq[mask]++;
            // freq[mask]++;
            for(int j=0;j<10;j++){
                ans += freq[mask^(1<<j)];
            }
        }
        return ans;
    }
}