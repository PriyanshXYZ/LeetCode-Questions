class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int currVowels = 0;
        int max = 0;
        int si = 0;
        for(int ei=0;ei<n;ei++){
            if(isVowel(s.charAt(ei))){
                currVowels++;
            }
            while(ei-si+1>k){
                if(isVowel(s.charAt(si))){
                    currVowels--;
                }
                si++;
            }
            max =  Math.max(currVowels,max);
        }
        return max;
    }
    public boolean isVowel(Character ch){
        if(ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch=='u'){
            return true;
        }
        return false;
    }
}