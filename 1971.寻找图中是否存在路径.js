/*
 * @lc app=leetcode.cn id=1971 lang=javascript
 *
 * [1971] 寻找图中是否存在路径
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function(n, edges, source, destination) {
    let UnionFind = function(n) {
        this.parent = Array.from({ length: n }, (_, i) => i);
        this.rank = Array(n).fill(1);
    }
    UnionFind.prototype.find = function(x) {
        if (this.parent[x] !== x) {
            this.parent[x] = this.find(this.parent[x]);
        }
        return this.parent[x];
    };
    UnionFind.prototype.union = function(x, y) {
        let rootX = this.find(x);
        let rootY = this.find(y);
        if (rootX !== rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                this.parent[rootY] = rootX;
            } else if (this.rank[rootX] < this.rank[rootY]) {
                this.parent[rootX] = rootY;
            } else {
                this.parent[rootY] = rootX;
                this.rank[rootX]++;
            }
        }
    }
    UnionFind.prototype.connected = function(x, y) {
        return this.find(x) === this.find(y);
    }

    let uf = new UnionFind(n);
    for (let [u, v] of edges) {
        uf.union(u, v);
    }
    return uf.connected(source, destination);
};
// @lc code=end

