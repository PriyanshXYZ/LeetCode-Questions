class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length==1)return 1;
        int chunks=0;
        int num=arr[0];
        for(int i=0;i<arr.length;i++){
            num=Math.max(num,arr[i]);
            if(num==i)chunks++;
        }
        return chunks;
    }
}