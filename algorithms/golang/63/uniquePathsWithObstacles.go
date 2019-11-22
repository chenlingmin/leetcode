package main

import "fmt"

func uniquePathsWithObstacles(obstacleGrid [][]int) int {

	if obstacleGrid == nil {
		return 0
	}
	if obstacleGrid[0][0] == 1 {
		return 0
	}
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	dp[0][0] = 1

	for i := 1; i < m; i++ {
		if dp[i-1][0] != 0 && obstacleGrid[i][0] != 1 {
			dp[i][0] = 1
		}
	}
	for i := 1; i < n; i++ {
		if dp[0][i-1] != 0 && obstacleGrid[0][i] != 1 {
			dp[0][i] = 1
		}
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {

			if obstacleGrid[i][j] != 1 {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}
	return dp[m-1][n-1]
}

func main() {
	fmt.Println(uniquePathsWithObstacles([][]int{
		{0, 0},
		{1, 1},
		{0, 0},
	}))

	fmt.Println(uniquePathsWithObstacles([][]int{
		{0, 0, 0},
		{0, 1, 0},
		{0, 0, 0},
	}))

	fmt.Println(uniquePathsWithObstacles([][]int{
		{1},
	}))
}
