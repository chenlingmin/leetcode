import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int openLock(String[] deadends, String target) {
        String init = "0000";

        HashSet<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }
        if (deadendSet.contains(target)) return -1;
        if (deadendSet.contains(init)) return -1;
        if (init.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(init);
        visited.put(init, 0);

        while (!queue.isEmpty()) {
            String cur = queue.remove();
            for (String nextCode : nextCode(cur)) {
                if (!deadendSet.contains(nextCode) && !visited.containsKey(nextCode)) {
                    queue.add(nextCode);
                    visited.put(nextCode, visited.get(cur) + 1);
                    if (nextCode.equals(target)) {
                        return visited.get(nextCode);
                    }
                }
            }
        }
        return -1;
    }

    private String[] nextCode(String code) {
        char[] chars = code.toCharArray();
        String[] ret = new String[8];
        for (int i = 0; i < 4; i++) {
            char originalChar = chars[i];
            chars[i] = Character.forDigit((chars[i] - '0' + 1) % 10, 10);
            ret[2 * i] = new String(chars);
            chars[i] = originalChar;
            chars[i] = Character.forDigit((chars[i] - '0' + 9) % 10, 10);
            ret[2 * i + 1] = new String(chars);
            chars[i] = originalChar;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().openLock(new String[]{
                "0201", "0101", "0102", "1212", "2002"
        }, "0202"));
        System.out.println(new Solution().openLock(new String[]{
                "8888"
        }, "0009"));
        System.out.println(new Solution().openLock(new String[]{
                "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
        }, "8888"));
        System.out.println(new Solution().openLock(new String[]{
                "0000"
        }, "8888"));
        System.out.println(new Solution().openLock(new String[]{
                "0201", "0101", "0102", "1212", "2002"
        }, "0000"));
    }
}
