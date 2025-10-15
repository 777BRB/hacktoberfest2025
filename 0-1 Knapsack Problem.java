class Solution {
    public int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(weights[i-1]<=w)
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1]+dp[i-1][w-weights[i-1]]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][W];
    }
}
