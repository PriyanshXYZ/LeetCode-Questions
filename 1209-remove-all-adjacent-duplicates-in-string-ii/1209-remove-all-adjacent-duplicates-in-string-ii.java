class Solution {
    //O(n)
    class Pair{
        char ch;
        int x;
        Pair(char ch,int x){
            this.ch=ch;
            this.x=x;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stk=new  Stack();
        char[] str=s.toCharArray();
        for(char ch:str){
            if(stk.isEmpty()){
                stk.push(new Pair(ch,1));
            }else{
                if(stk.peek().ch==ch){
                   stk.peek().x++; 
                }else{
                    stk.push(new Pair(ch,1));
                }
            }
            if(stk.peek().x==k){
                    stk.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            Pair p=stk.pop();
            while(p.x-->0){
                sb.append(p.ch);    
            }
            
        }
        return sb.reverse().toString();
    }
    
    //O(n*k)    
    public String removeDuplicatesMethod1(String s, int k) {
        Stack<Character> main=new Stack();
        char[] str=s.toCharArray();
        for(char ch:str){
            Stack<Character> aux=new Stack();
            aux.push(ch);
            
            while(!main.isEmpty() && main.peek()==ch){
                aux.push(main.pop());
            }
            if(aux.size()!=k){
                while(!aux.isEmpty()){
                    main.push(aux.pop());
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!main.isEmpty()){
            sb.append(main.pop());
        }
        return sb.reverse().toString();
    }
}