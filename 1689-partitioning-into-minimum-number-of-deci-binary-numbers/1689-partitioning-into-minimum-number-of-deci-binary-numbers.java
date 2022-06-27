class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++){
            int num=Integer.parseInt(n.charAt(i)+"");
            
            max=Math.max(num,max);
        }
        return max;
    }
}