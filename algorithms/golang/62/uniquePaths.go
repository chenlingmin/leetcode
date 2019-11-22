package main

import "fmt"

// 递归解法
//func uniquePaths(m int, n int) int {
//	if m <= 1 || n <= 1 {
//		return 1
//	}
//	return uniquePaths(m-1, n) + uniquePaths(m, n-1)
//}

// 动态规划解法
func uniquePaths(m int, n int) int {
	if m <= 0 || n <= 0 {
		return 0
	}

	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}

	for i := 0; i < m; i++ {
		dp[i][0] = 1
	}
	for i := 0; i < n; i++ {
		dp[0][i] = 1
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[m-1][n-1]
}

func main() {
	fmt.Println(uniquePaths(3, 2))
	fmt.Println(uniquePaths(3, 3))
	fmt.Println(uniquePaths(7, 3))
}
