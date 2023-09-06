/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {

    // 跟785是相同的，实质就是判断能否二分
    // 注意这里编号是从1开始而不是0开始，所以有的地方是n+1,并且循环从1开始
    // 另外dislike实际上是双向图，对于路径两头的节点都需要添加对方

    boolean[] res;
    boolean[] visit;
    boolean ok = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 编号从1开始，所以尺寸扩到n+1
        res = new boolean[n + 1];
        visit = new boolean[n + 1];

        List<Integer>[] graph = buildGraph(n, dislikes);

        // 遍历从1开始
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                traverse(i, graph);
            }
        }

        return ok;
    }

    private void traverse(int n, List<Integer>[] graph) {
        // 如果已经不是二分图了直接返回
        if (!ok) {
            return;
        }

        // 标记当前节点已经走过
        visit[n] = true;

        // 遍历与当前节点相邻的所有节点
        for (int next: graph[n]) {
            // 如果没有遍历过则给一个与当前节点不同的颜色，然后继续DFS遍历
            if (!visit[next]) {
                res[next] = !res[n];
                traverse(next, graph);
            } else {
                // 如果遍历过则需要满足颜色不同，如果颜色相同则不是二分图
                if (res[next] == res[n]) {
                    ok = false;
                    return;
                }
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 编号从1开始，所以初始化容量为n+1
        List<Integer>[] graph = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        // dislike是双向的，两个节点要互相把对方加进去
        for (int[] dis: dislikes) {
            int i = dis[0];
            int j = dis[1];
            graph[i].add(j);
            graph[j].add(i);
        }

        return graph;
    }
}
// @lc code=end

