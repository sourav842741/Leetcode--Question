class Solution {

    int[][][] memo;

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;

        memo = new int[m][n][m+n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return solve(grid, 0, 0, 0);
    }

    public boolean solve(char[][] grid, int i, int j, int balance) {

        int m = grid.length;
        int n = grid[0].length;

        if(balance < 0) return false;

        if(memo[i][j][balance] != -1) {
            return memo[i][j][balance] == 1;
        }

        int newBalance = balance;

        if(grid[i][j] == '(') newBalance++;
        else newBalance--;

        if(i == m-1 && j == n-1) {
            return newBalance == 0;
        }

        boolean down = false;

        if(i+1 < m) {
            down = solve(grid, i+1, j, newBalance);
        }

        boolean right = false;

        if(j+1 < n) {
            right = solve(grid, i, j+1, newBalance);
        }

        boolean ans = down || right;

        memo[i][j][balance] = ans ? 1 : 0;

        return ans;
    }
}