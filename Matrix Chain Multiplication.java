class Solution {
    public int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];
        for(int len=2; len<n; len++){
            for(int i=1; i<n-len+1; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+dims[i-1]*dims[k]*dims[j]);
                }
            }
        }
        return dp[1][n-1];
    }
}
