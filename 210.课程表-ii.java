/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {

    // 有BFS和DFS两种方法，DFS在后半部分

    /*
     * 下面是BFS广度优先的方法，类似207题，找到入度为0的节点开始遍历，BFS的遍历顺序就是一种上课的方案，
     * 因为每次都是取的入度为0的节点，也就是没有前置依赖的课程
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 保存每个节点的入度
        int[] indegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            int from = pre[1], to = pre[0];
            indegree[to]++;
        }

        // BFS的核心，保存当前入度为0的节点，也就是没有前置依赖的课程
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录已经遍历过的节点数
        int count = 0;
        // 记录遍历的顺序，也就是最终结果
        int[] res = new int[numCourses];
        while(queue.size() != 0) {
            // 取出一个入度为0的节点，放到res中
            int index = queue.poll();
            res[count] = index;
            count++;
            // 遍历这个节点指向的下一个节点，并把它们的入度-1
            for(int next: graph[index]) {
                indegree[next]--;
                // 如果下一个节点入度为0，则加入queue
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 如果所有节点都遍历过，则路径有效
        if (count == numCourses) {
            return res;
        } else {
            // 否则说明有环，不能形成方案
            return new int[]{};
        }
    }
     
    /*
     * 下面是DFS深度优先的方法，从任意一个节点开始沿着路径遍历
     */
    // 遍历图的时候，记录其后序遍历，然后把后序遍历翻转即可
    // 后续遍历实际上是把根节点放在所有子节点之后，也就是子节点都遍历完了之后才可以遍历根节点
    // 那么把它反过来，就是把根节点遍历完了之后，才可以遍历子节点，也就是当前课程上完之后才可以上其它课程

    // 为什么前序遍历不可以，而是要后序遍历再反过来？
    // 因为遍历图的时候，是从任意一个点i开始沿着依赖关系遍历的，这个点i并不一定是全局依赖关系的起点
    // 也就是说可能i的背后还有其他节点指向i，前序遍历的话，就会先遍历i及它延伸出去的节点，
    // 然后再从i背后的节点遍历直到i为止，这样会导致本来处于中间的i却变成了前序遍历的开头
    // 而后序遍历的话，可以保证这个遍历顺序的第一个节点必定是图的某一个终点
    // （因为只有遍历到末端，才会开始回退，往遍历中添加节点）
    // 这样从末端回退到点i，然后即使i的身后有其他节点j指向i，这个j也会成为后面遍历的结果，
    // 这样后序遍历就可以保证最基础的依赖课程j肯定在后面，而高等的课程i在前面
    // 然后再翻转这个遍历，就形成了正确的依赖顺序
    // boolean[] visit;
    // boolean[] onPath;
    // boolean cycle = false;
    // // 记录当前遍历的顺序
    // List<Integer> postOrder = new LinkedList<Integer>();

    // public int[] findOrder(int numCourses, int[][] prerequisites) {

    //     visit = new boolean[numCourses];
    //     onPath = new boolean[numCourses];
    //     List<Integer>[] graph = buildGraph(numCourses, prerequisites);

    //     for (int i = 0; i < numCourses; i++) {
    //         traverse(graph, i);
    //     }

    //     // 有环就没有上课方案
    //     if (cycle) {
    //         return new int[]{};
    //     } else {
    //         // 翻转后序遍历就是结果
    //         Collections.reverse(postOrder);
    //         int[] res = new int[numCourses];
    //         for (int i = 0; i < numCourses; i++) {
    //             res[i] = postOrder.get(i);
    //         }
    //         return res;
    //     }
    // }

    // private void traverse(List<Integer>[] graph, int select) {
    //     if (onPath[select]) {
    //         cycle = true;
    //         return;
    //     }
    //     if (visit[select] || cycle) {
    //         return;
    //     }

    //     visit[select] = true;
    //     onPath[select] = true;

    //     for (int i: graph[select]) {
    //         traverse(graph, i);
    //     }

    //     // 后序遍历记录
    //     postOrder.add(select);
    //     onPath[select] = false;
    // }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        for (int[] pre: prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        return graph;
    }
}
// @lc code=end

