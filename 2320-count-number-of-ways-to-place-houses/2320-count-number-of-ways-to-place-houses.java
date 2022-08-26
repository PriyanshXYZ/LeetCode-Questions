class Solution {
    int mod=(int)(1e9+7);
    public int countHousePlacements(int n) {
        if(n==1)return 4;
        long building=1;
        long noBuilding=1;
        for(int i=2;i<=n;i++){
            long currInc=(building+noBuilding)%mod;
            long currExc=building;
            
            building=currInc;
            noBuilding=currExc;
        }
        long ans=(building+noBuilding)%mod;
        return (int)(ans*ans%mod);
        
    }
}