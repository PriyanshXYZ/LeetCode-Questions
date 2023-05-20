class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //1.we first create union between single queries
        parent=new HashMap();
        multiplier=new HashMap();
        
        //making disjoint set
        for(List<String> eqn : equations){
            String s1=eqn.get(0);
            String s2=eqn.get(1);
            parent.put(s1,s1);
            parent.put(s2,s2);
            multiplier.put(s1,1.0);
            multiplier.put(s2,1.0);
        }
        
        //doing union based on values
        for(int i=0;i<equations.size();i++){
            String s1=equations.get(i).get(0);
            String s2=equations.get(i).get(1);
            
            String s1Lead=find(s1);
            String s2Lead=find(s2);
            
            double m1=multiplier.get(s1);
            double m2=multiplier.get(s2);
            
            
            //union of set leads
            parent.put(s1Lead,s2Lead);
            multiplier.put(s1Lead, (values[i] * m2 )/ m1);
            
        }
        // System.out.println(parent);
        // System.out.println(multiplier);
        double[] res=new double[queries.size()];
        int idx=0;
        //checking for queries
        for(List<String> query : queries){
            String s1=query.get(0);
            String s2=query.get(1);
            
            //both any of element is not present in map then invalid idx
            if(parent.containsKey(s1)==false || parent.containsKey(s2)==false){
                res[idx]=-1;
                idx++;
                continue;
            }
            String s1Lead=find(s1);
            String s2Lead=find(s2);
            //if both are in different union i.e they are not attached
            if(!s1Lead.equals(s2Lead)){
                res[idx]=-1;
                idx++;
                continue;
            }
            
            double m1=multiplier.get(s1);
            double m2=multiplier.get(s2);
            
            res[idx]=m1/m2;
            idx++;
        }
        // System.out.println(parent);
        // System.out.println(multiplier);
        return res;
    }
    HashMap<String,String> parent;
    HashMap<String,Double> multiplier;
    
    private String find(String x){
        if(parent.get(x).equals(x)){
            return parent.get(x);
        }else{
            String currPar=parent.get(x);
            String newPar=find(currPar);
            
            parent.put(x,newPar);
            multiplier.put(x,multiplier.get(currPar)*multiplier.get(x));
            return newPar;
        }
    }
}