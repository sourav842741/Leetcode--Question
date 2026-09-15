class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int  i = 0; i < n; i++){
            dp[i][i] = 1;
            if(i > 0 && s.charAt(i) == s.charAt(i-1)){
                dp[i-1][i] = 1;
            }
        } 

        for(int len = 3; len <= n; len++){
            int i = 0;
            int j = len - 1;
            while(j < n){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                i++;
                j++;
            }
        }

   


        int[] dp1 = new int[n + 1];
        for(int i = n - k; i >= 0; i--){
            dp1[i] = dp1[i+1];
            for(int j = i + k - 1; j < n; j++){
                if(dp[i][j] > 0){
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j+1]);
                }
            }
        }


        return dp1[0];


    }
}