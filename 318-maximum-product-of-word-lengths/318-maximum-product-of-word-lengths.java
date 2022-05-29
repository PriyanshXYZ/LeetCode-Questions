class Solution {
    public int maxProduct(String[] words) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            
            for(int j=i+1;j<words.length;j++){
                boolean unique=true;
                int k=0;
                while(k<words[j].length()){
                    if(words[i].contains(words[j].charAt(k)+"")){
                        unique=false;
                        break;
                    }
                    k++;
                }
                
                if(unique){
                max=Math.max(words[j].length()*words[i].length(),max);
                }
                
            }
        }
        return max!=Integer.MIN_VALUE?max:0;
    }
}