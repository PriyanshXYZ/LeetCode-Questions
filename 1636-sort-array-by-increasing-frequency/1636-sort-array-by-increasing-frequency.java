class Solution {
    static class Pair{
        int key;
        int value;
        
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return key+"<->"+value;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for(int val : nums) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        
        List<Pair> sorted = new ArrayList<>(freqMap.entrySet().stream().map(a->new Pair(a.getKey(),a.getValue())).toList());
        
        Collections.sort(sorted, (a,b)->{
            return a.value!=b.value ?(a.value - b.value) : (b.key - a.key);
        });
        
        int[] res = new int[nums.length];
        int idx = 0;
        for(Pair p : sorted) {
            int freq= p.value;
            while(freq-->0)
                res[idx++] = p.key;
        }
        return res;
    }
}