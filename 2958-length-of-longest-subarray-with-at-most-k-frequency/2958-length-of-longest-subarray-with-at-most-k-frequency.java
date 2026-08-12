class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;

        for (int r = 0; r < nums.length; r++) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            while (freq.get(nums[r]) > k) {
                int leftVal = nums[l];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) {
                    freq.remove(leftVal);
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}