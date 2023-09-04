/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.Queue;

class Solution {

    // 有DFS和BFS两种方法，DFS在后半部分

    /*
     * 下面是BFS广度优先的方法，从任意一个入度为0的点开始，每次把入度为0的节点遍历一遍
     */

    // 广度优先基于“入度”的概念，入度表示有多少个节点指向当前节点，如果入度为0，则没有其他节点指向当前节点，
    // 也就是当前节点没有前置依赖，我们可以递归地把所有入度为0的节点拿出来，这些就是当前没有前置依赖的可以直接上的课
    // 这些节点拿出来以后，可以理解为把这些节点从图里删掉，也就是把它们指向的下一个节点的入度-1，这样有可能形成新的入度为0的节点

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        // 存储每个节点的入度
        int[] indegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            int from = pre[1], to = pre[0];
            // 节点入度+1
            indegree[to]++;
        }

        // 队列是BFS的特点，用来保存入度为0的节点
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录有多少节点已经遍历过了
        int count = 0;
        while(queue.size() != 0) {
            // 取出一个入度为0的节点
            int index = queue.poll();
            // 遍历节点数+1
            count++;
            // 遍历这个节点所指向的下一个节点
            for (int next: graph[index]) {
                // 下一个节点入度-1
                indegree[next]--;
                // 如果下一个节点入度为0，加入队列
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 如果所有节点都遍历完了，说明没有环，可以形成上课方案
        return count == numCourses;

    }

    /*
     * 下面是DFS深度优先的方法，从每一个节点开始一直沿着路径往前走
     */
    // // 记录已经走过的节点
    // boolean[] visited;
    // // 记录当前的路径
    // boolean[] onpath;
    // // 记录有没有环
    // boolean cycle = false;

    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     visited = new boolean[numCourses];
    //     onpath = new boolean[numCourses];

    //     List<Integer>[] grap = buildGraph(numCourses, prerequisites);

    //     // 依次尝试从每一个节点出发，检查是否存在环
    //     // 如果是一棵树，实际上只要从根节点出发遍历就可以，
    //     // 但这是图，且此题的图可能不是连接在一起的，有可能是好几个独立的部分
    //     // 因此需要从每一个节点出发尝试遍历，才可以把图完整走一遍
    //     // visit记录这个节点有没有走过，避免重复计算，跟onpath不同，
    //     // onpath是会随着一个节点遍历完之后清空，然后从下个节点出发时又重新记录
    //     // 比如有：a-b,c这样的图，c是独立的，ab相连
    //     // 如果只从a出发，那么c是无法遍历到的，因此需要从a,b,c每个节点都出发遍历一次
    //     // 当第一次从a出发遍历，走到b，遍历完成，visit里记录了a和b，随着此轮遍历完，onpath也清空了
    //     // 然后从b出发作为起点开始遍历，发现visit有了，说明包含b的图已经走过了，可以不走了，退出后onpath也清空
    //     // 然后开始从c出发，
    //     for (int i = 0; i < numCourses; i++) {
    //         traverse(grap, i);
    //     }

    //     return !cycle;
    // }

    // // 在图graph中，选择走节点s
    // private void traverse(List<Integer>[] graph, int s) {
    //     // 如果已经在路径上了，说明形成了环
    //     if (onpath[s]) {
    //         cycle = true;
    //         return;
    //     }

    //     // 如果已经遍历过
    //     if (visited[s] || cycle) {
    //         return;
    //     }

    //     visited[s] = true;
    //     onpath[s] = true;

    //     for (int i: graph[s]) {
    //         traverse(graph, i);
    //     }

    //     onpath[s] = false;
    // }

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

