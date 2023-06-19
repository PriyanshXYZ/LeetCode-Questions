class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int n = gain.length;
        int max = 0;
        for(int i=1;i<=n;i++){
            alt += gain[i-1];
            max = Math.max(alt,max);
        }
        return max;
    }
}