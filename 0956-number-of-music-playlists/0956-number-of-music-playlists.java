class Solution {
    int mod = (int)(1e9+7);
    Long[][] dp;
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new Long[goal + 1][n + 1];
        return (int)memo(0, 0, goal, k, n);
    }

    private long memo(int songCount, int uniqueSongs, int goal, int k, int n) {
        //base case
        if(songCount == goal && uniqueSongs == n){
            return dp[songCount][uniqueSongs] = 1L;
        }
        if (uniqueSongs > n) { // If you've somehow played more unique songs than available (invalid path)
            return 0;
        }
        // You might also want to add:
        if (songCount > goal) { // If you've overshot the goal length (invalid path)
            return 0;
        }

        if(dp[songCount][uniqueSongs] != null) return dp[songCount][uniqueSongs];

        long sameSongs = 0;
        if(uniqueSongs > k) { // we can play unique songs only when we played more than k songss
            sameSongs = memo(songCount + 1, uniqueSongs, goal, k, n) * (uniqueSongs - k);
            sameSongs %= mod;
        }
        long differentSongs = 0;
        if(uniqueSongs < n) {
            differentSongs = memo(songCount + 1, uniqueSongs + 1, goal, k, n) * (n - uniqueSongs);
            differentSongs %= mod;
        }
        return dp[songCount][uniqueSongs] = sameSongs % mod + differentSongs % mod;
    }
}