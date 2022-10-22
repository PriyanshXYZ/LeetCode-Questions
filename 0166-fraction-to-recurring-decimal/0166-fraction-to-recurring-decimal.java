class Solution {
    public String  fractionToDecimal(int num, int dem){
        // code here
        long quo=Math.abs((long)num/dem);
        long rem=num%dem;
        
        
        String ans=quo+"";
        if(num<0 && dem<0){
            ans=quo+"";
        }else if(num<0 || dem<0){
            ans="-"+quo+"";
        }
        if(rem==0){
            if(quo==0)return "0";
            return ans;
        }
            
        
        ans+=".";
        String frac="";
        
        HashMap<Long,Integer> map=new HashMap<>();
        int idx=0;
        
        while(rem!=0 && map.containsKey(rem)==false){
            map.put(rem,idx);
            idx++;
            
            rem*=10;
            quo=rem/dem;
            rem=rem%dem;
            frac+=Math.abs(quo)+"";
        }
        // System.out.println(map);
        if(rem==0){
            ans+=frac;
        }else{
            idx=map.get(rem);
            ans+=frac.substring(0,idx)+"("+frac.substring(idx)+")";
        }
        return ans;
        
    }
}