class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int longestObstacleCourse[] = new int[length]; // array to store the length of the longest obstacle course for each index i
        int lis[] = new int[length]; // array to store the lowest increasing subsequence of length i+1 seen so far
        int lisLength = 0; // variable to keep track of the length of the longest increasing subsequence seen so far
        for (int i = 0; i < length; i++) {
            int left = 0, right = lisLength;
            // perform binary search to find the rightmost insertion position for the current obstacle in the lis array
            while (left < right) {
                int middle = (left + right) >> 1;
                if (lis[middle] <= obstacles[i]) left = middle + 1;
                else right = middle;
            }
            // update the lis array with the current obstacle at the rightmost insertion position if the current obstacle is smaller than the obstacle at the rightmost insertion position
            if (left >= lisLength || lis[left] > obstacles[i]) lis[left] = obstacles[i];
            // if the rightmost insertion position is equal to lisLength, increment lisLength by 1
            if (left == lisLength) lisLength++;
            // update the longestObstacleCourse array with the length of the increasing subsequence seen so far, which is equal to the rightmost insertion position plus 1
            longestObstacleCourse[i] = left + 1;
        }
        return longestObstacleCourse; // return the longestObstacleCourse array as the final result
    }
}