class Solution {
    public int minDistance(String word1, String word2) {
        
        // return recursion(0, 0, word1.toCharArray(), word2.toCharArray());
        
        // Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        
        // return memo(0, 0, word1.toCharArray(), word2.toCharArray(), dp);
        
        // return tabulation(word1, word2);
        
        Integer[] prev = new Integer[word2.length()+1];
        
        for(int j = 0;j < prev.length; j++){
            
            prev[j] = j>0?1+prev[j-1]:0;
            
        }
        
        for(int i = 1; i < word1.length() + 1; i++){
            
            Integer[] curr = new Integer[word2.length()+1];
            
            for(int j = 0; j < prev.length; j++){
                
                if(j==0){
                    curr[j] = 1 + prev[j];
                    continue;
                }
                
                int ans = Integer.MAX_VALUE;
                
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    
                    ans = prev[j - 1];
                    
                }else{
                    int insert = 1 + curr[j - 1];

                    int replace = 1 + prev[j - 1];

                    int delete = 1 + prev[j];

                    ans = Math.min(insert, Math.min(replace, delete));    
                }
                
                curr[j] = ans;
                
            }
            
            prev = curr;
            
        }
        
        return prev[word2.length()];
        
    }
    public int tabulation(String word1, String word2){
        
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i < dp.length; i++){
            
            dp[i][0] = i>0?1+dp[i-1][0]:0;
            
        }
        
        for(int j = 0;j < dp[0].length; j++){
            
            dp[0][j] = j>0?1+dp[0][j-1]:0;
            
        }
        
        for(int i = 1; i < dp.length; i++){
            
            for(int j = 1; j < dp[0].length; j++){
                
                int ans = Integer.MAX_VALUE;
                
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    
                    ans = dp[i - 1][j - 1];
                    
                }else{
                    int insert = 1 + dp[i][j - 1];

                    int replace = 1 + dp[i - 1][j - 1];

                    int delete = 1 + dp[i - 1][j];

                    ans = Math.min(insert, Math.min(replace, delete));    
                }
                
                dp[i][j] = ans;
            }
        }
        return dp[word1.length()][word2.length()];
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