class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++){
            int num=n.charAt(i)-'0';
            max=Math.max(num,max);
            if(max==9)return 9;
        }
        return max;
    }
}