class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        int n = nums.length;
        int strt=0,end = 0;
        long count=0;
        int pairCnt = 0;
        for(; end < n; end++){
            pairCnt+=map.getOrDefault(nums[end],0);// 
            
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            
            while(strt<=end && pairCnt>=k){
                if(map.getOrDefault(nums[strt],0)>1){
                    pairCnt-=(map.get(nums[strt])-1);
                }
                
                map.put(nums[strt],map.getOrDefault(nums[strt],0)-1);
                strt++;
            }
            // so basically we are moving j until we get subarray smaller than j , so when we reach curr<k so adding all previous elements and we would still get our valid good subarray
            count += strt;
        }
        
        return count;
    }
}
/*
It is sliding window because we are going over range i to j and we are dealing with that range for our answer and not thinking about other part of the array
like for eg take => nums = [3,1,4,3,2,2,4], k = 2 
```
//curr describes about how many pairs do we have till now
i=0,j=0   [3]        curr=0
i=1,j=0   [3,1]        curr =0
i=2,j=0   [3,1,4]      curr =0
i=3,j=0   [3,1,4,3]   (here we got our first pair) curr=1
i=4,j=0   [3,1,4,3,2]    curr=1
i=5,j=0   [3,1,4,3,2,2]  curr =2 our condition is satisfied that we got curr = k
                         now we need to increment j pointer until we do not get curr < k
                         i=6,j=0                       [3,1,4,3,2,2]
                         i=6,j=1                       [1,4,3,2,2]                  here our condition is violated so we get out of loop
                         curr = curr - (elements which were in pair with curr removed element)
         it means we got 1 subarray satisfying the condition ie.[3,1,4,3,2,2]
res +=1
i=6,j=1  [1,4,3,2,2,4]      curr =2 = k
                       increment j pointer until we do not get curr < k
                        i=6,j=1                         [1,4,3,2,2,4] 
                        i=6,j=2                         [4,3,2,2,4]        still curr is 2
                       i=6,j=3                          [3,2,2,4]              curr=1
so we got 3 subarray which satiesfies >=k that are           [1,4,3,2,2,4] 
                                                                                         [3,1,4,3,2,2,4]
                                                                                         [4,3,2,2,4]
res+=3 (which is j)
```

*/
