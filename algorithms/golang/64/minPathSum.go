package main

import "fmt"

func minPathSum(grid [][]int) int {

	for i := len(grid) - 1; i >= 0; i-- {
		for j := len(grid[i]) - 1; j >= 0; j-- {
			if i+1 < len(grid) && j+1 < len(grid[i]) {
				down := grid[i+1][j]
				right := grid[i][j+1]
				if down < right {
					grid[i][j] = grid[i][j] + down
				} else {
					grid[i][j] = grid[i][j] + right
				}
			} else if i+1 < len(grid) {
				down := grid[i+1][j]
				grid[i][j] = grid[i][j] + down
			} else if j+1 < len(grid[i]) {
				right := grid[i][j+1]
				grid[i][j] = grid[i][j] + right
			}

		}
	}

	return grid[0][0]

}

func main() {
	ints := [][]int{
		{1, 3, 1},
		{1, 5, 1},
		{4, 2, 1},
	}

	fmt.Println(minPathSum(ints))
}
