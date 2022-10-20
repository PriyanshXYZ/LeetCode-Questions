class Solution {
    
    public String intToRoman(int num) {
       Map<Integer,String> map=new TreeMap(Collections.reverseOrder());
        //assigning value in hashmap
        map.put(1,"I");map.put(4,"IV");map.put(5,"V");map.put(9,"IX");map.put(10,"X");map.put(40,"XL");map.put(50,"L");
        map.put(90,"XC");map.put(100,"C");map.put(400,"CD");map.put(500,"D");map.put(900,"CM");map.put(1000,"M");
        // System.out.println(map);
        StringBuilder sb=new StringBuilder();
        for(int key:map.keySet()){
            
            while(num>=key){
                sb.append(map.get(key));
                num-=key;
            }
            if(num==0)break;
        }
        return sb.toString();
    }
}