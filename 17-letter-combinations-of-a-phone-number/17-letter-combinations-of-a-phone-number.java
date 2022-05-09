class Solution {
    String[] numpad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()<1)return new ArrayList();
        return recursion(0,digits,new StringBuilder()); 
    }
    
    public List<String> recursion(int idx,String digits,StringBuilder output){
        if(idx==digits.length()){
            List<String> base=new ArrayList();
            base.add(output.toString());
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
            ans.addAll(recursion(idx+1,digits,output.append(ch)));
            output.deleteCharAt(output.length()-1);
        }
        
        return ans;
    }
}