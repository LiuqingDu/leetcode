/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // 可以想象把图摊开成放射形状，最小高度树的根肯定在中心的位置，
        // 最外面那些度为1的节点肯定就是最小高度树的叶子节点
        // 我们把所有这些度为1的节点都删掉，那么就会出现一些新的度为1的节点
        // 循环删除最外面那些度为1的节点，最后剩下的就是最中心的根节点
        // 其实就是已知叶子节点是度为1的节点，然后寻找离这些叶子节点最近的那一个根节点
        // 每次都从叶子节点删去一层，逐步靠近根

        LinkedList<Integer> res = new LinkedList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        // 节点和节点的对应关系
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }

        // 每个节点的度
        int[] degree = new int[n];
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            degree[a]++;
            degree[b]++;

            // 添加节点对应关系
            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // queue存的是最外层的度为1的节点
            // 每次进入一轮，意味着图里还有度为1的节点，那么这些节点应当作为可能的res
            // 需要把上一轮的res清空，表示上一轮的度为1的节点还不是根节点
            res = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 把这轮的度为1的节点加入res
                res.add(cur);
                // 找到它的相邻节点，把邻居的度-1，表示删除了当前节点，邻居少一个度
                for (int neighbor: map.get(cur)) {
                    degree[neighbor]--;
                    // 如果邻居的度也是1了，那就加入队列
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return res;

    }
}
// @lc code=end

