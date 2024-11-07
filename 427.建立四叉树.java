/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    // 明显递归，不断将当前的区域划分为四个子区域
    // 然后递归每个子区域
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }
    
    private Node construct(int[][] grid, int row, int col, int size) {
        // 叶子节点就直接创建出来
        if (isLeaf(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }
        
        // 分割为四个区域
        int newSize = size / 2;
        Node topLeft = construct(grid, row, col, newSize);
        Node topRight = construct(grid, row, col + newSize, newSize);
        Node bottomLeft = construct(grid, row + newSize, col, newSize);
        Node bottomRight = construct(grid, row + newSize, col + newSize, newSize);
        
        // 用四个子节点拼接成父节点
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    
    // 检查是不是叶子节点
    private boolean isLeaf(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

