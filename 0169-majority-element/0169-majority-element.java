class Solution {
    public int majorityElement(int[] a) {
        return majorityElements(a, 2).get(0);
    }

    public static List<Integer> majorityElements(int[] nums, int k) {
        if (k < 2) throw new IllegalArgumentException("k must be >= 2");

        // Step 1: Find potential candidates (at most k-1)
        Map<Integer, Integer> candidates = new HashMap<>();

        for (int num : nums) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k - 1) {
                candidates.put(num, 1);
            } else {
                // Decrement all counts
                List<Integer> toRemove = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : candidates.entrySet()) {
                    int newCount = entry.getValue() - 1;
                    if (newCount == 0) {
                        toRemove.add(entry.getKey());
                    } else {
                        candidates.put(entry.getKey(), newCount);
                    }
                }
                // Remove zero-count candidates
                for (int key : toRemove) {
                    candidates.remove(key);
                }
            }
        }

        // Step 2: Verify actual counts
        Map<Integer, Integer> actualCounts = new HashMap<>();
        for (int num : nums) {
            if (candidates.containsKey(num)) {
                actualCounts.put(num, actualCounts.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : actualCounts.entrySet()) {
            if (entry.getValue() > nums.length / k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
//with space
class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
}