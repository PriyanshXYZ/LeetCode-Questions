class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect1=Math.abs(ay1-ay2)*Math.abs(ax1-ax2);
        int rect2=Math.abs(by1-by2)*Math.abs(bx1-bx2);
        
        //when is merging possible
        int rect3=0;
        if(check(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2)){
            int xlen=Math.abs(Math.min(ax2,bx2)-Math.max(ax1,bx1));
            int ylen=Math.abs(Math.min(by2,ay2)-Math.max(ay1,by1));
            rect3=xlen*ylen;
        }
        return rect1+rect2-rect3;
    }
    private boolean check(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        //if starting of second rectangle is greater than ending of first
        //if ending of second is lesser than starting of first
        if(bx2<=ax1 || bx1>=ax2 || ay1>=by2 || ay2<=by1)return false;
        return true;
    }
}