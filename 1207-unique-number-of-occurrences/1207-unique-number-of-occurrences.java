class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for(int key : map.keySet()){
            if(freq.containsKey(map.get(key)))return false;
            freq.put(map.get(key), key);
        }
        return true;
    }
}