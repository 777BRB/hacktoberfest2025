class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int i=1;i<=K;i++){
            Arrays.fill(dp[i], N);
        }
        for(int k=1;k<=K;k++){
            dp[k][0]=0; dp[k][1]=1;
        }
        for(int n=1;n<=N;n++){
            dp[1][n]=n;
        }
        for(int k=2;k<=K;k++){
            for(int n=2;n<=N;n++){
                for(int x=1;x<=n;x++){
                    dp[k][n] = Math.min(dp[k][n], 1 + Math.max(dp[k-1][x-1], dp[k][n-x]));
                }
            }
        }
        return dp[K][N];
    }
}
