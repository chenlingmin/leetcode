package main

import (
	"fmt"
)

func main() {

	fmt.Println(integerBreak(1))
	fmt.Println(integerBreak(2))
	fmt.Println(integerBreak(3))
	fmt.Println(integerBreak(11))
	fmt.Println(integerBreak(10))
	fmt.Println(integerBreak(4))
}

func integerBreak(n int) int {
	if n == 1 {
		return 1
	}

	dp := make([]int, n+1)
	dp[1] = 1
	for i := 2; i <= n; i++ {
		max := -1
		for j := 1; j < i; j++ {
			a, b := j*dp[i-j], j*(i-j)
			max = Max(Max(a, b), max)
		}
		dp[i] = max
	}
	return dp[n]
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
