class Solution {
    public int largestAltitude(int[] gain) {
        int[] alt = new int[gain.length + 1];
        int n = gain.length;
        int max = 0;
        for(int i=1;i<=n;i++){
            alt[i] = alt[i-1] + gain[i-1];
            max = Math.max(alt[i],max);
        }
        return max;
    }
}