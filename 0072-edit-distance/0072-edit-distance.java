class Solution {
    public int minDistance(String word1, String word2) {
        // return recursion(0, 0, word1.toCharArray(), word2.toCharArray());
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return memo(0, 0, word1.toCharArray(), word2.toCharArray(), dp);
    }
    
    public int recursion(int i, int j, char[] word1, char[] word2){
        //base case
        if(i == word1.length)return word2.length - j;
        if(j == word2.length)return word1.length - i;
        
        
        if(word1[i] == word2[j]){
            return recursion(i + 1, j + 1, word1, word2);
        }else{
            
            int insert = 1 + recursion(i, j + 1, word1, word2);//if we insert at ith position then we need to check that character with word2 of index+1
            
            int replace = 1 + recursion(i + 1, j + 1, word1, word2);//simply move to greater index
            
            int delete = 1 + recursion(i + 1, j, word1, word2);//if we delete move to i+1 and check for same j
            
            return Math.min(insert, Math.min(replace, delete));
        }
    }
    
    public int memo(int i, int j, char[] word1, char[] word2, Integer[][] dp){
        //base case
        if(i == word1.length)return word2.length - j;
        if(j == word2.length)return word1.length - i;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(word1[i] == word2[j]){
            return dp[i][j] = memo(i + 1, j + 1, word1, word2, dp);
        }else{
            
            int insert = 1 + memo(i, j + 1, word1, word2, dp);//if we insert at ith position then we need to check that character with word2 of index+1
            
            int replace = 1 + memo(i + 1, j + 1, word1, word2, dp);//simply move to greater index
            
            int delete = 1 + memo(i + 1, j, word1, word2, dp);//if we delete move to i+1 and check for same j
            
            return dp[i][j] = Math.min(insert, Math.min(replace, delete));
        }
    }
}