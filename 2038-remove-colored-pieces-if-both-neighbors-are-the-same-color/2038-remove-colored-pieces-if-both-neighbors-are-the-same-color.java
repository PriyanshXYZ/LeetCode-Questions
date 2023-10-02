class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0;
        int bobMoves = 0;
        
        for(int i=1;i<colors.length()-1;i++){
            char curr = colors.charAt(i);
            char prev = colors.charAt(i-1);
            char ahead = colors.charAt(i+1);
            if(curr==prev && curr == ahead && curr=='A'){
                aliceMoves++;
            }
            if(curr==prev && curr == ahead && curr=='B'){
                bobMoves++;
            }
        }
        return aliceMoves - bobMoves >0;
    }
}