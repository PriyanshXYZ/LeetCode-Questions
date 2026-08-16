class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = 0;

        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }

        int penalty = 0;

        for (int arrival : arrivalTime) {
            int r = arrival % period;

            if (r >= maxGreen) {
                penalty = Math.max(penalty, period - r);
            }
        }

        return penalty;
    }
}