class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long[] stats = new long[stations.length]; 
        for (int i = 0; i < stations.length; i++) { 
            stats[i] = stations[i]; 
        } 
        return solve(stats, r, k); 
     } 

     public long solve(long[] stations, int r, long k) { 
          int n = stations.length; 
          long max = 0; 
          for (long e : stations) { 
              max = Math.max(e, max); 
          } 
          long low = 0; 
          long high = Long.MAX_VALUE; 
          long ans = 0; 
          while (low < high) { 
              long mid = (low + high)/(long)2; 
              long windowSum = 0; 
              long need = 0; 
              long[] temp = stations.clone(); 
               for (int i = 0; i < r; i++) 
                   windowSum += temp[i]; 
               for (int i = 0, rear = r, front = i-r-1; i < n && need<=k; i++, front++, rear++) { 
                   if (front >= 0) 
                       windowSum -= temp[front]; 
                   if (rear < n) 
                    windowSum += temp[rear]; 
                   if (windowSum < mid) { 
                       long remain = mid - windowSum; 
                       need += remain; 
                       windowSum+=remain; 
                       temp[Math.min(rear,n-1)] += remain; 
                    }
               }
               if (need > k) { 
                   high = mid;
               }else 
                   low = mid + 1;
          } 
          return low-1; 
     } 
}