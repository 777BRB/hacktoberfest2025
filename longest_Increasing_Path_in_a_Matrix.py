class Solution:
    def longestIncreasingPath(self, matrix):
        if not matrix:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        directions = [(1,0), (-1,0), (0,1), (0,-1)]
        
        def dfs(i, j):
            if dp[i][j] != 0:
                return dp[i][j]
            
            max_len = 1
            for dx, dy in directions:
                x, y = i + dx, j + dy
                if 0 <= x < m and 0 <= y < n and matrix[x][y] > matrix[i][j]:
                    max_len = max(max_len, 1 + dfs(x, y))
            
            dp[i][j] = max_len
            return dp[i][j]
        
        longest = 0
        for i in range(m):
            for j in range(n):
                longest = max(longest, dfs(i, j))
        
        return longest
