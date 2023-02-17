class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
		Map<Integer, Integer> fullLakeMap = new HashMap<>();
		TreeSet<Integer> dryDay = new TreeSet<>();
		int[] res = new int[n];
		int idx = 0;
		for(int i=0;i<n;i++){
			if(rains[i]==0){
				dryDay.add(i);
				res[idx++]=1;
			}else{
				int lake = rains[i];
				if(fullLakeMap.containsKey(lake)){
					Integer num = dryDay.higher(fullLakeMap.get(lake));
					if(num==null)return new int[]{};
					res[num] = lake;
					dryDay.remove(num);
				}
				fullLakeMap.put(lake,i);
				res[idx++] = -1;
			}
		}
		return res;
    }
}