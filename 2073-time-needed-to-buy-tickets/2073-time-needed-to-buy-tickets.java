class Solution {
    public int timeRequiredToBuy(int[] t, int k) {
        return IntStream.range(0, t.length).map(i -> Math.min(t[i], i > k ? t[k] - 1 : t[k])).sum();
    }
}