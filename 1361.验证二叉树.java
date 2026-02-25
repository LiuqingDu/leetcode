/*
 * @lc app=leetcode.cn id=1361 lang=java
 *
 * [1361] 验证二叉树
 */

// @lc code=start
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 1. 记录每个节点父节点数
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {

            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1) return false; // 多个父节点
            }

            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1) return false;
            }
        }

        // 2. 找根节点
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) return false; // 多个根
                root = i;
            }
        }

        if (root == -1) return false; // 没有根


        // 3. DFS遍历检查连通性和环
        boolean[] visited = new boolean[n];

        if (!dfs(root, leftChild, rightChild, visited))
            return false;

        // 必须访问所有节点
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }


    private boolean dfs(int node, int[] left, int[] right, boolean[] visited) {

        if (node == -1) return true;

        if (visited[node]) return false; // 出现环

        visited[node] = true;

        return dfs(left[node], left, right, visited) &&
               dfs(right[node], left, right, visited);
    }
}
// @lc code=end

