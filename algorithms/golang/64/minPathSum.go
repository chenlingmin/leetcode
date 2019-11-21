package main

import (
	"fmt"
)

func minPathSum(grid [][]int) int {

	for i := len(grid) - 1; i >= 0; i-- {
		for j := len(grid[i]) - 1; j >= 0; j-- {
			down := down(&grid, i, j)
			right := right(&grid, i, j)

			if down != -1 && right != -1 {
				grid[i][j] = grid[i][j] + min(down, right)
			} else if down != -1 {
				grid[i][j] = grid[i][j] + down
			} else if right != -1 {

				grid[i][j] = grid[i][j] + right
			}

		}
	}

	return grid[0][0]

}

func down(grid *[][]int, i, j int) int {
	if i+1 < len(*grid) {
		return (*grid)[i+1][j]
	}
	return -1
}

func right(grid *[][]int, i, j int) int {
	if j+1 < len((*grid)[i]) {
		return (*grid)[i][j+1]
	}
	return -1
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	ints := [][]int{
		{1, 3, 1},
		{1, 5, 1},
		{4, 2, 1},
	}

	fmt.Println(minPathSum(ints))
}
