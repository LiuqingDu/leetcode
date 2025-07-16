/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // 如果 a 比 b 富有, 从 a 到 b 画一条有向边
        // 那么最终会得到一张有向无环图
        // 每个点出发都是比自己穷的人
        // 对于最富有的人, 那么他自己就最不安静的
        // 也就是说, 如果一个点没有入度(是一个端点),也就是没人比他富有
        // 则他就最不安静的
        // 初始化所有人的answer为自己
        // 然后从所有端点开始, 如果自己比下一个穷人b安静,则用自己去更新answer[b]
        // 否责就不更新
        // 并记录路径上的最不安静的人
        // 整个过程是先把最外圈的断点处理完, 然后再处理内圈的断点

        int n = quiet.length;
        // 创建一个图, 存储每个人比谁富有
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 入度数组, 记录每个人比哪些人富有
        int[] inDegree = new int[n];
        for (int[] r : richer) {
            // 记录 r[0] 比 r[1] 富有
            // 即 r[0] -> r[1]
            graph[r[0]].add(r[1]);
            // r[1] 的入度加一, 也就是有一个人比r[1]富有
            inDegree[r[1]]++;
        }

        int[] answer = new int[n];
        // 初始化每个人都是最不安静的
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }

        // 使用队列进行拓扑排序
        // 从入度为0的点开始, 也就是没有人比他富有的人
        // 最富有的人来说,最不安静的人就是他自己
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            // 遍历当前点的所有出边
            // 也就是比当前人还穷的人
            for (int next : graph[current]) {
                // 如果当前人的最不安静的人比下一个人的最不安静的人还不安静
                // 则更新
                if (quiet[answer[current]] < quiet[answer[next]]) {
                    answer[next] = answer[current];
                }
                // 下一个人的入度减一
                // 表示当前人已经处理完了
                // 如果下一个人的入度为0, 则加入队列
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return answer;
    }
}
// @lc code=end

