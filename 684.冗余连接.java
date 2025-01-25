/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // 一棵树是无向图, 有 n 个节点, n-1 个边
        // 增加一个边以后,就有 n 个边,且形成了一个环
        // 实际上就是要找到这个环,且找出环上的最后一个边
        // 用并查集可以找到两个点是否连通
        // 先假设没有边只有点,依次把边画出来,也就是把两个点连起来
        // 如果新的边的两个点在图里已经连通了,那么说明这个新的边就是导致成环的边
        // 也是最后一个边

        int n = edges.length;
        // 节点是从 1 开始的,没有 0, 初始化索引是 0~n
        int[] parent = new int[n + 1];
        // 先把每个点的父节点记为自己, 也就是每个点都是独立的
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 如果两个点的父节点不同,说明两边还没有连通
            // 那么就把它们连起来, 表示画下了这个边
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                // 如果父节点相同,说明这两个点已经连通了,这就是形成环的最后一条边
                return edge;
            }
        }
        return new int[0];
    }

    // 并查集的完整模板中要根据 rank 来决定把哪个子树挂在哪个子树上
    // rank 表示树的高度, 尽量把高度低的挂到高度更高的上面
    // 这样可以降低树的高度
    // 这道题不涉及, 因为我们只想知道是否连通, 所以谁挂谁不重要
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    // 递归查找当前节点的父节点并记录下来,这是为了压缩高度,把所有节点尽量挂在根节点上
    // 避免比如 [0, 0, 1, 2] 这样, 节点 3 的父节点是 2,节点 2 的父节点是 1, 节点 1 的父节点是 0
    // 压缩后是 [0, 0, 0, 0] 每个节点的根节点都是 0
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
// @lc code=end

