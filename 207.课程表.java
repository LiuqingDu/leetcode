/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    // 记录已经走过的节点
    boolean[] visited;
    // 记录当前的路径
    boolean[] onpath;
    // 记录有没有环
    boolean cycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onpath = new boolean[numCourses];

        List<Integer>[] grap = buildGraph(numCourses, prerequisites);

        // 依次尝试从每一个节点出发，检查是否存在环
        for (int i = 0; i < numCourses; i++) {
            traverse(grap, i);
        }

        return !cycle;
    }

    // 在图graph中，选择走节点s
    private void traverse(List<Integer>[] graph, int s) {
        // 如果已经在路径上了，说明形成了环
        if (onpath[s]) {
            cycle = true;
            return;
        }

        // 如果已经遍历过
        if (visited[s] || cycle) {
            return;
        }

        visited[s] = true;
        onpath[s] = true;

        for (int i: graph[s]) {
            traverse(graph, i);
        }

        onpath[s] = false;
    }

    // 构建图，使用邻接表，表里记录了每个节点以及与它相邻的节点
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        // graf[i]就是一个清单，记录节点i有哪些邻居节点
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        // 上了后者的课才可以上前者课，图就是指向上课顺序，也就是后者指向前者
        for (int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
}
// @lc code=end

