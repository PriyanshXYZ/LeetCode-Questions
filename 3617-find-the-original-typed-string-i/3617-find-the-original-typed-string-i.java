class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            while(i<n-1 && word.charAt(i)==word.charAt(i+1)){
                i++;
                cnt++;
            }
            ans += cnt;
        }
        return ans + 1;
    }
}