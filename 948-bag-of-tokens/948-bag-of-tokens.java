class Solution {
    public int bagOfTokensScore(int[] token, int power) {
        Arrays.sort(token);
        if(token.length==0 || power<token[0])return 0;
        //greedy thinking established here is we try to gain maximum score initially until power<token
        // once we are out of power we use our score to get highest token in our power
        int currScore=0;
        int score=0;
        int i=0,j=token.length-1;
        while(i<=j){
            while(i<token.length && power>=token[i]){
                power-=token[i];
                currScore++;
                i++;
            }
            score=Math.max(currScore,score);
            if(i>=token.length)break;
            if(currScore>0 && power<token[i]){
                currScore--;
                power+=token[j];
                j--;
            }else if(currScore<=0 || power<token[i]){
                break;
            }
        }
        return score;
    }
}