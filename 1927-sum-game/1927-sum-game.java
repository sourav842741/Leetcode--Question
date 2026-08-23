class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        // Check left half
        for (int i = 0; i < n / 2; i++) {

            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Check right half
        for (int i = n / 2; i < n; i++) {

            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        // Odd number of '?' → Alice wins
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Bob can make the sums equal
        if (leftSum - rightSum
                == 9 * (rightQ - leftQ) / 2) {
            return false;
        }

        // Otherwise Alice wins
        return true;
    }
}