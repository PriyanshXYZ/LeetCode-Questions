class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int maxSum=0;
        int j=0;
        List<Character> list=new ArrayList();
        list.add(s.charAt(j));
        int sum=1;
        j++;
        while(j<s.length()){
            char ch2=s.charAt(j);
            
            if(list.contains(ch2)){
                int size=list.size();
                while(true){
                    if(list.get(0)==ch2){
                        list.remove(0);
                        break;
                    }
                    list.remove(0); 
                }
                list.add(ch2);
                sum=list.size();
            }else{
                list.add(ch2);
                sum++;
            }
            j++;
            maxSum=Math.max(sum,maxSum);
        }
        maxSum=Math.max(sum,maxSum);
        return maxSum;
    }
}