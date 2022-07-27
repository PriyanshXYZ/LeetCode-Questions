class Solution {
    public int reachNumber(int target) {
        int moves = 0;
        target = Math.abs( target );
        
        while( true ){
            int range = moves * ( moves + 1 ) / 2;
            if( range >= target ){
                if(( range % 2 == 0 && target % 2 == 0 ) || (range % 2 !=0 && target % 2 !=0) ){
                    return moves;
                }else{
                    moves++;
                }
            }else {
                moves++;
            }
        }
        
    }
}