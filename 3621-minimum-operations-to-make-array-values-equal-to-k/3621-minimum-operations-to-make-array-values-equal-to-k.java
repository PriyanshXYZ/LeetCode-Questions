class Solution {
    public int minOperations(int[] nums, int k) {
        if(Arrays.stream(nums).boxed().anyMatch(a->a<k))return -1;
        Set<Integer> unq = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return unq.contains(k)?unq.size()-1:unq.size();
    }
}