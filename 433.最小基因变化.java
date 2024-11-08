/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // bfs，将start每一位都尝试每一种可能的变化
        // 如果在bank当中则添加到visited中，否则抛弃
        // 直到变化到end为止
        Set<String> cnt = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        char[] keys = {'A', 'C', 'G', 'T'};        
        for (String w : bank) {
            cnt.add(w);
        }
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (!cnt.contains(endGene)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(endGene)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

