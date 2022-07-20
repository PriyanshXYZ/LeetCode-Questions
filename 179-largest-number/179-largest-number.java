class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        String[] a = new String[n];
        for(int i = 0;i < n ;i++){
            a[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(a,new Comparator<String>(){
           @Override
            public int compare(String a,String b){
                String s1=a+b;
                String s2=b+a;
                return s2.compareTo(s1);
            }
        });
        if(a[0].equals("0"))return "0";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a.length;i++){
            sb.append(a[i]);
        }
        return sb.toString();
    }
}