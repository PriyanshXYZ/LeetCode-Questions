class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0;
        int j = 0;
        int ans = 0;
        
        while(i<g.length && j<s.length){
            while(j<s.length && g[i] > s[j]){
                j++;
            }
            if(j==s.length)return ans;
            if(g[i] <= s[j]){
                ans++;
                j++;
            }
            i++;
        }
        return ans;
    }
}