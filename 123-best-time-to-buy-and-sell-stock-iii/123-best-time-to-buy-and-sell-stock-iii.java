class Solution {
    public int maxProfit(int[] stock) {
        int n=stock.length;
        int[][] ahead=new int[2][3];
        for(int idx=n;idx>=0;idx--){
            int[][] curr=new int[2][3];
            for(int flag=0;flag<2;flag++){
                for(int trCount=0;trCount<=2;trCount++){
                    if(trCount==0){
                        curr[flag][trCount]=0;     
                        continue;
                    }

                    if(idx==n){
                        curr[flag][trCount]=0;
                        continue;
                    }

                    if(flag==1){
                    //buy
                        int profitWhenBuyingHere=-stock[idx] + ahead[0][trCount];
                        int profitWhenNotBuyinhHere=ahead[1][trCount];
                        curr[flag][trCount]=Math.max(profitWhenBuyingHere,profitWhenNotBuyinhHere);
                    }else{
                    //sell
                        int profitWhenSellingHere=+stock[idx] + ahead[1][trCount-1];//transaction complete
                        int profitWhenNotSellingHere=ahead[0][trCount];
                        
                        curr[flag][trCount]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
                    }
                }
            }
            ahead=curr;
        }
       return ahead[1][2];
    }
}