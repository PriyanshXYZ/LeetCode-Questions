class Solution {
    class Pair{
        char ch;
        int idx;
        Pair(char ch,int idx){
            this.ch=ch;
            this.idx=idx;
        }
    }
    public String pushDominoes(String dominoes) {
        StringBuilder sb=new StringBuilder();
        
        sb.append('L');
        for(char ch: dominoes.toCharArray())sb.append(ch);
        sb.append('R');
        Pair prev=new Pair('L',0);
        for(int i=1;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch=='L'){
                if(prev.ch=='L'){
                    //L-L
                    int j=prev.idx+1;
                    while(j<i){
                        sb.setCharAt(j,'L');
                        j++;
                    }
                }else{
                    //R-L
                    //check for odd and even gap between dominoes
                    int dist=i-prev.idx-1;
                    int j=prev.idx+1;
                    int idx=dist/2+j;
                    
                    if(dist%2!=0){
                        while(j<i){
                            if(j<idx){
                                sb.setCharAt(j,'R');
                            }else if(j>idx){
                                sb.setCharAt(j,'L');
                            }
                            j++;
                        }
                    }else{
                        while(j < i){
                            if(j<idx){
                                sb.setCharAt(j,'R');
                            }else{
                                sb.setCharAt(j,'L');
                            }
                            j++;
                        }
                    }
                }
                prev=new Pair('L',i);
            }else if(ch=='R'){
                if(prev.ch=='L'){
                    //L-R
                }else{
                    // R-R
                    int j=prev.idx+1;
                    while(j < i){
                        sb.setCharAt(j,'R');
                        j++;
                    }
                }
                prev=new Pair('R',i);
            }
        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}