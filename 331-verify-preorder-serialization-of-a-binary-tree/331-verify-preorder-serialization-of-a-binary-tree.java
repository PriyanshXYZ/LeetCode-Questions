class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] pre=preorder.split(",");
        int capacity=1;
        for(String s:pre){
            
            if(--capacity<0){
                return false;
            }
            if(!s.equals("#")){
            capacity+=2;
            }

        }
        return capacity==0;               
    }
}