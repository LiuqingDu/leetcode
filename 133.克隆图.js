/*
 * @lc app=leetcode.cn id=133 lang=javascript
 *
 * [133] 克隆图
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    
    let visited = new Map();

    if (!node) {
        return node;
    }

    let queue = [];
    queue.push(node);
    visited.set(node, new Node(node.val, []));

    while (queue.length) {
        let n = queue.shift();
        for (let neighbor of n.neighbors) {
            if (!visited.has(neighbor)) {
                visited.set(neighbor, new Node(neighbor.val, []));
                queue.push(neighbor);
            }
            visited.get(n).neighbors.push(visited.get(neighbor));
        }
    }

    return visited.get(node);    
};
// @lc code=end

