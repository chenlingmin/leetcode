import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int R, C;

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        boolean[][] visited = new boolean[R][C];

        int[][] dirs = {
                {0, -1},  // 左
                {0, 1},   // 右
                {-1, 0},  // 上
                {1, 0},   // 下
                {-1, -1}, // 左上
                {-1, 1},  // 右上
                {1, -1},  // 左下
                {1, 1},   // 右下
        };

        int[][] dis = new int[R][C];

        if (grid[0][0] == 1) return -1;
        if (R == 1 && C == 1) return 1;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int curx = cur / C, cury = cur % C;
            for (int d = 0; d < 8; d++) {
                int nextx = curx + dirs[d][0];
                int nexty = cury + dirs[d][1];
                if (nextx + 1 == R  && nexty + 1 == C && grid[nextx][nexty] == 0) {
                    return dis[curx][cury] + 1;
                }
                if (inArea(nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == 0) {
                    queue.add(nextx * R + nexty);
                    visited[nextx][nexty] = true;
                    if (dis[nextx][nexty] == 0)
                        dis[nextx][nexty] = dis[curx][cury] + 1;
                    else if (dis[nextx][nexty] > 0)
                        dis[nextx][nexty] = Math.min(dis[curx][cury] + 1, dis[nextx][nexty]);
                }
            }
        }
        return -1;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        System.out.println(new Solution().shortestPathBinaryMatrix(grid));
    }
}