class Solution {
    class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(0, 0, n - 1, arr);
        }

        private void build(int i, int l, int r, int[] arr) {
            if (l == r) {
                tree[i] = arr[l];
                return;
            }

            int mid = l + (r - l) / 2;
            build(2 * i + 1, l, mid, arr);
            build(2 * i + 2, mid + 1, r, arr);

            tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
        }

        public boolean findAvailable(int val) {
            return find(0, 0, n - 1, val);
        }

        private boolean find(int i, int l, int r, int val) {
            if (tree[i] < val) return false;

            if (l == r) {
                tree[i] = -1; // mark basket as used
                return true;
            }

            int mid = l + (r - l) / 2;
            boolean placed;

            if (tree[2 * i + 1] >= val) {
                placed = find(2 * i + 1, l, mid, val);
            } else {
                placed = find(2 * i + 2, mid + 1, r, val);
            }

            tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
            return placed;
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        private void update(int i, int l, int r, int index, int val) {
            if (l == r) {
                tree[i] = val;
                return;
            }

            int mid = l + (r - l) / 2;
            if (index <= mid) {
                update(2 * i + 1, l, mid, index, val);
            } else {
                update(2 * i + 2, mid + 1, r, index, val);
            }

            tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree tree = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            if (!tree.findAvailable(fruit)) {
                unplaced++;
            }
        }

        return unplaced;
    }
}