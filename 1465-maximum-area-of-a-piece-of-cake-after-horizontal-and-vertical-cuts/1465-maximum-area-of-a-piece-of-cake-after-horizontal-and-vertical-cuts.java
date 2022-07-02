class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long ht=horizontalCuts[0];
        long wdt=verticalCuts[0];
        int mod=(int)(Math.pow(10,9)+7);
        long maxArea=0;
        for(int i=0;i<horizontalCuts.length-1;i++){
            ht=Math.max(horizontalCuts[i+1]-horizontalCuts[i],ht);
        }
        ht=Math.max(h-horizontalCuts[horizontalCuts.length-1],ht);
        for(int i=0;i<verticalCuts.length-1;i++){
            wdt=Math.max(verticalCuts[i+1]-verticalCuts[i],wdt);
        }
        wdt=Math.max(w-verticalCuts[verticalCuts.length-1],wdt);
        maxArea=((ht%mod)*(wdt%mod))%mod;
        return (int)maxArea;
    }
}