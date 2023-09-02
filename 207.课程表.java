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
        // 如果是一棵树，实际上只要从根节点出发遍历就可以，
        // 但这是图，且此题的图可能不是连接在一起的，有可能是好几个独立的部分
        // 因此需要从每一个节点出发尝试遍历，才可以把图完整走一遍
        // visit记录这个节点有没有走过，避免重复计算，跟onpath不同，
        // onpath是会随着一个节点遍历完之后清空，然后从下个节点出发时又重新记录
        // 比如有：a-b,c这样的图，c是独立的，ab相连
        // 如果只从a出发，那么c是无法遍历到的，因此需要从a,b,c每个节点都出发遍历一次
        // 当第一次从a出发遍历，走到b，遍历完成，visit里记录了a和b，随着此轮遍历完，onpath也清空了
        // 然后从b出发作为起点开始遍历，发现visit有了，说明包含b的图已经走过了，可以不走了，退出后onpath也清空
        // 然后开始从c出发，
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

