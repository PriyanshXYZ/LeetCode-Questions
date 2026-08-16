class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
    TreeSet<Integer> lightSet = Arrays.stream(lights)
            .boxed()
            .collect(Collectors.toCollection(TreeSet::new));

    int minPenalty = 0;

    for (int arrival : arrivalTime) {
        int r = arrival % period;

        // Find the smallest green duration strictly greater than r
        Integer green = lightSet.higher(r);

        if (green == null) {
            // Every light is red
            minPenalty = Math.max(minPenalty, period - r);
        }
    }

    return minPenalty;
}
}