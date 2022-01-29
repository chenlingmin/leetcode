import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {

        this.graph = graph;
        colors = new int[graph.length];

        for (int v = 0; v < graph.length; v++) {
            if (colors[v] == 0) {
                if (!bfs(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int s) {
        colors[s] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : graph[v]) {
                if (colors[w] == 0) {
                    queue.add(w);
                    colors[w] = -colors[v];
                } else if (colors[w] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}