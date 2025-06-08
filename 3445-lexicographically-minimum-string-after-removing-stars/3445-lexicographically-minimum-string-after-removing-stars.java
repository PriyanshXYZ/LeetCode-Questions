class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Integer> idxMinHeap = new PriorityQueue<>((a,b) -> s.charAt(a)==s.charAt(b)?(b-a):(s.charAt(a)-s.charAt(b)));
        Set<Integer>  toBeRemovedIdx = new HashSet();
        for(int i =0 ; i < n; i++) {
            if(s.charAt(i)!='*'){
                idxMinHeap.add(i);
            }else{
                toBeRemovedIdx.add(idxMinHeap.remove());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!toBeRemovedIdx.contains(i) && ch!='*')
                sb.append(ch);
        }
        return sb.toString();
    }
}