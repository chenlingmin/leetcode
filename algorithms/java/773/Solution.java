import java.util.*;

class Solution {
    private int result = encode(new int[][]{{1, 2, 3}, {4, 5, 0}});
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public int slidingPuzzle(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();

        int init = encode(board);
        if (init == result) {
            return 0;
        }
        queue.add(init);
        visited.put(init, 0);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int next : next(cur)) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if (result == next) {
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }

    List<Integer> next(int cur) {
        List<Integer> result = new ArrayList<>();
        int[][] board = decode(cur);

        int zero;
        for (zero = 0; zero < 6; zero++)
            if (board[zero / 3][zero % 3] == 0)
                break;

        int zx = zero / 3, zy = zero % 3;

        for (int d = 0; d < dirs.length; d++) {
            int nextx = zx + dirs[d][0], nexty = zy + dirs[d][1];
            if (inArea(nextx, nexty)) {
                swap(board, zx, zy, nextx, nexty);
                result.add(encode(board));
                swap(board, zx, zy, nextx, nexty);
            }
        }
        return result;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int t = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = t;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    int[][] decode(int encode) {
        int a = (encode % 1000000) / 100000;
        int b = (encode % 100000) / 10000;
        int c = (encode % 10000) / 1000;
        int d = (encode % 1000) / 100;
        int e = (encode % 100) / 10;
        int f = (encode % 10);
        return new int[][]{{a, b, c}, {d, e, f}};
    }

    int encode(int[][] board) {
        return 100000 * board[0][0]
                + 10000 * board[0][1]
                + 1000 * board[0][2]
                + 100 * board[1][0]
                + 10 * board[1][1]
                + board[1][2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(new Solution().slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(new Solution().slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));

    }
}
