import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int minResult = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink window if sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            // Valid subarray found
            if (currentSum == target) {
                int len = right - left + 1;
                
                // Check if a valid non-overlapping subarray exists to the left
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minResult = Math.min(minResult, len + minLen[left - 1]);
                }
                
                // Update the running minimum length found so far
                currentMinLen = Math.min(currentMinLen, len);
            }
            
            // Store the best length up to the current index
            minLen[right] = currentMinLen;
        }
        
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}