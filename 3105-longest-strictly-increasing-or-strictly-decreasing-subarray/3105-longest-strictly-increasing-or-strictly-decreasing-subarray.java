class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int ic = 1;
        int dc = 1;

        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                ic++;
                dc = 1;
                ans = Math.max(ans, ic);
            } else if (nums[i - 1] > nums[i]) {
                dc++;
                ic = 1;
                ans = Math.max(ans, dc);
            } else {
                ic = 1;
                dc = 1;
            }
        }

        return ans;
    }
}