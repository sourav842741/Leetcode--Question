class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if(n == 1_000_000_000_000_000L) ans += 1;
        if(n >= 1_000_000_000_000L) {
            long count = n - 1_000_000_000_000L + 1;
            ans += 1l * count * 4;
            n -= count;
        } 

        if(n >= 1_000_000_000L) {
            long count = n - 1_000_000_000L + 1;
            ans += 1l * count * 3;
            n -= count;
        }

        if(n >= 1_000_000L) {
            long count = n - 1_000_000L + 1;
            ans += 1l * count * 2;
            n -= count;
        }

        if(n >= 1_000L) {
            long count = n - 1_000L + 1;
            ans += 1l * count;
            n -= count;
        }

        return ans;
    }
}


// 1_000_000_000_123

// 1_000_000_000_123 - 1_000_000_000_000 = 123