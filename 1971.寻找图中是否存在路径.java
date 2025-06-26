/*
 * @lc app=leetcode.cn id=1971 lang=java
 *
 * [1971] 寻找图中是否存在路径
 */

// @lc code=start
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 并查集
        // 原理是将所有节点分成若干个连通分量
        // 如果 source 和 destination 在同一个连通分量中，则存在路径
        // 初始时每个节点都是一个独立的连通分量
        // 通过 union 操作将两个节点所在的连通分量合并
        // 最后判断 source 和 destination 是否在同一个连通分量中
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            uf.union(u, v);
        }
        return uf.connected(source, destination);
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            // 初始化每个节点的父节点为自己，秩为 1
            // 这里的秩表示树的高度，初始时每个节点都是一个独立的连通分量
            // 所以每个节点的秩为 1
            // 注意这里的秩并不是严格的树的高度，而是一个近似的表示
            // 在 union 操作中，秩用于优化合并操作
            // 通过秩来决定哪个节点作为根节点，从而减少树的高度
            // 这样可以在后续的 find 操作中减少路径长度，提高效率
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // 查找操作，找到节点 x 的根节点
        // 路径压缩优化：在查找过程中，将路径上的所有节点直接连接到根节点上
        // 这样可以减少后续的查找操作的路径
        // 使得 find 操作的时间复杂度接近 O(1)
        // 这里使用递归实现路径压缩
        // 如果 parent[x] 不是 x，说明 x 不是根节点
        // 递归查找 parent[x] 的根节点，并将 parent[x]
        // 直接连接到根节点上
        // 这样可以减少路径长度，提高效率
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // 合并操作，将两个节点 x 和 y 所在的连通分量合并
        // 首先找到 x 和 y 的根节点 rootX 和 rootY
        // 如果 rootX 和 rootY 不同，说明 x 和 y 不在同一个连通分量中
        // 根据秩来决定哪个节点作为根节点
        // 如果 rootX 的秩大于 rootY 的秩，则将 rootY 的父节点设置为 rootX
        // 如果 rootX 的秩小于 rootY 的秩，则将 rootX 的父节点设置为 rootY
        // 如果 rootX 和 rootY 的秩相等，则将 rootY 的父节点设置为 rootX
        // 并将 rootX 的秩加 1
        // 这样可以保持树的平衡，减少树的高度
        // 使得后续的 find 操作更加高效
        // 时间复杂度为 O(α(n))，其中 α(n) 是阿克曼函数的反函数
        // 在实际应用中，α(n) 的值非常小
        // 所以可以认为 find 和 union 操作的时间复杂度接近 O(
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        // 判断两个节点 x 和 y 是否在同一个连通分量中
        // 通过查找操作找到 x 和 y 的根节点
        // 如果根节点相同，说明 x 和 y 在同一个连通分量
        // 返回 true，否则返回 false
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
// @lc code=end

