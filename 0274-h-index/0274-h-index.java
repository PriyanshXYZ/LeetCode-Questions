class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 1)return Math.min(citations[0], 1);
        int n = citations.length;
        Arrays.sort(citations);
        int max = 0;

        for(int i = 0 ; i < n; i++) {
            int currMinCitation = citations[i];
            int paperCitedCount = n - i + 1;
            if(paperCitedCount >= currMinCitation)
                max = Math.max(max, currMinCitation);
        }
        return max;
    }
}