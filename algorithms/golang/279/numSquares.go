package main

import "fmt"

func numSquares(n int) int {
	dp := make([]int, n+1)

	for i := 1; i <= n; i++ {
		min := int(^uint(0) >> 1)
		for j := 1; j*j <= i; j++ {
			min = Min(min, dp[i-j*j])
		}
		dp[i] = min + 1
	}
	return dp[n]
}

func Min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {

	//for i := 1; i < 100; i++ {
	//	fmt.Println(numSquares(i))
	//}
	//
	//fmt.Println(numSquares(10))
	//fmt.Println(numSquares(1))
	//fmt.Println(numSquares(4))
	//fmt.Println(numSquares(9))
	fmt.Println(numSquares(12))
}
