class Solution {
    String[] numpad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()<1)return new ArrayList();
        return recursion(0,digits,""); 
    }
    
    public List<String> recursion(int idx,String digits,String output){
        if(idx==digits.length()){
            List<String> base=new ArrayList();
            base.add(output);
            return base;
        }
        if(idx>digits.length()){
            List<String> base=new ArrayList();
            return base;
        }
        List<String> ans=new ArrayList();
        char a=digits.charAt(idx);
        for(int i=0;i<numpad[a-'0'].length();i++){
            char ch=numpad[a-'0'].charAt(i);
            ans.addAll(recursion(idx+1,digits,output+ch));
        }
        
        return ans;
    }
}