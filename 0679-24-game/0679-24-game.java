class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return backtracking(list);
    }

    private boolean backtracking(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24.0) < 1e-1;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                double num1 = cards.get(i);
                double num2 = cards.get(j);

                List<Double> nextCards = new ArrayList<>();

                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        nextCards.add(cards.get(k));
                    }
                }

                // Try all 6 possible operations and recurse
                // Add
                nextCards.add(num1 + num2);
                if (backtracking(nextCards)) return true;
                nextCards.remove(nextCards.size() - 1); // Backtrack

                // Subtract
                nextCards.add(num1 - num2);
                if (backtracking(nextCards)) return true;
                nextCards.remove(nextCards.size() - 1); // Backtrack

                nextCards.add(num2 - num1);
                if (backtracking(nextCards)) return true;
                nextCards.remove(nextCards.size() - 1); // Backtrack

                // Multiply
                nextCards.add(num1 * num2);
                if (backtracking(nextCards)) return true;
                nextCards.remove(nextCards.size() - 1); // Backtrack

                // Divide
                if (num2 != 0) {
                    nextCards.add(num1 / num2);
                    if (backtracking(nextCards)) return true;
                    nextCards.remove(nextCards.size() - 1); // Backtrack
                }
                if (num1 != 0) {
                    nextCards.add(num2 / num1);
                    if (backtracking(nextCards)) return true;
                    nextCards.remove(nextCards.size() - 1); // Backtrack
                }
            }
        }
        // No solution found from any combination
        return false;
    }
}