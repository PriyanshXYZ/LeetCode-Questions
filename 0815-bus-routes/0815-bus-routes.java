class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) return 0;

        // stop -> buses that visit this stop
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses
                    .computeIfAbsent(stop, k -> new ArrayList<>())
                    .add(bus);
            }
        }

        if (!stopToBuses.containsKey(source) ||
            !stopToBuses.containsKey(target)) {
            return -1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visitedStops = new HashSet<>();
        boolean[] visitedBuses = new boolean[routes.length];

        q.add(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            busesTaken++;

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                int stop = q.remove();

                for (int bus : stopToBuses.get(stop)) {

                    if (visitedBuses[bus]) continue;

                    visitedBuses[bus] = true;

                    // Take this bus and reach every stop on it
                    for (int nextStop : routes[bus]) {

                        if (nextStop == target) {
                            return busesTaken;
                        }

                        if (visitedStops.add(nextStop)) {
                            q.add(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}