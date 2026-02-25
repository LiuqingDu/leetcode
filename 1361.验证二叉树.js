/*
 * @lc app=leetcode.cn id=1361 lang=javascript
 *
 * [1361] 验证二叉树
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[]} leftChild
 * @param {number[]} rightChild
 * @return {boolean}
 */
var validateBinaryTreeNodes = function(n, leftChild, rightChild) {
    
    // 1. 统计入度（父节点数）
    let indegree = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {

        if (leftChild[i] !== -1) {
            indegree[leftChild[i]]++;
            if (indegree[leftChild[i]] > 1) return false;
        }

        if (rightChild[i] !== -1) {
            indegree[rightChild[i]]++;
            if (indegree[rightChild[i]] > 1) return false;
        }
    }

    // 2. 找唯一根节点
    let root = -1;

    for (let i = 0; i < n; i++) {
        if (indegree[i] === 0) {
            if (root !== -1) return false; // 多个根
            root = i;
        }
    }

    if (root === -1) return false; // 没有根


    // 3. DFS检查环和连通性
    let visited = new Array(n).fill(false);

    function dfs(node) {
        if (node === -1) return true;

        if (visited[node]) return false; // 有环

        visited[node] = true;

        return dfs(leftChild[node]) &&
               dfs(rightChild[node]);
    }

    if (!dfs(root)) return false;

    // 4. 必须访问所有节点
    return visited.every(v => v === true);
};
// @lc code=end

