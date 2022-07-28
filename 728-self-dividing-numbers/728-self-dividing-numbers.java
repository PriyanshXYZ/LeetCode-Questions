class Solution {
    public boolean selfDividing(int n){
        int count=Integer.toString(n).length();
        
        int temp=n;
        while(temp>0){
            int b=temp%10;
            if(b==0)return false;
            if(n%b!=0)return false;
            temp=temp/10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList();
        for(int i=left;i<=right;i++){
            if(selfDividing(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}