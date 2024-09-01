class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int pos1x = coordinate1.charAt(0)-'a';
        int pos1y = coordinate1.charAt(1)-'0' - 1;
        int pos2x = coordinate2.charAt(0)-'a';
        int pos2y = coordinate2.charAt(1)-'0' - 1;
        
        if(pos1y%2==0){
            if(pos2y%2==0){
                return (pos1x + pos2x)%2==0;
            }else{
                return (pos1x + pos2x)%2==1;
            }
        }else{
            if(pos2y%2==0){
                return (pos1x + pos2x)%2==1;
            }else{
                return (pos1x + pos2x)%2==0;
            }
        }
    }
}