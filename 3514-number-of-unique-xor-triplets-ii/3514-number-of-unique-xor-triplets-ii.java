class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        // Find maximum value from the array
        int maxEl = 0;
        for (int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, nums[i]);
        }

        // Find smallest power of 2 greater than maxEl
        int T = 1;
        while (T <= maxEl) {
            T = T * 2;
        }

        // Stores possible XOR pair values
        boolean[] s1 = new boolean[T];

        // Stores possible XOR triplet values
        boolean[] s2 = new boolean[T];

        // Find all possible XOR pair values
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        // Find all possible XOR triplet values
        for (int i = 0; i < T; i++) {
            if (s1[i]) {
                for (int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }

        // Count unique XOR triplet values
        int count = 0;

        for (int i = 0; i < T; i++) {
            if (s2[i]) {
                count++;
            }
        }

        return count;
    }
}