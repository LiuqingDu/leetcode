/*
 * @lc app=leetcode.cn id=558 lang=java
 *
 * [558] 四叉树交集
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

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        
        // 情况 1：t1 是叶子节点
        if (quadTree1.isLeaf) {
            // 如果 t1 全为 1，1 OR 任何矩阵都是 1，直接返回 t1
            // 如果 t1 全为 0，0 OR 任何矩阵都是那个矩阵本身，直接返回 t2
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        
        // 情况 2：t2 是叶子节点
        if (quadTree2.isLeaf) {
            // 同理，t2 全为 1 返回 t2，全为 0 返回 t1
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        // 情况 3：两个都不是叶子节点，递归合并 4 个子区域
        Node res = new Node();
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // 检查合并后的 4 个子节点是否可以压缩（四个子节点都是叶子且值相同）
        if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf
            && res.topLeft.val == res.topRight.val 
            && res.topLeft.val == res.bottomLeft.val 
            && res.topLeft.val == res.bottomRight.val) {
            
            res.isLeaf = true;
            res.val = res.topLeft.val;
            res.topLeft = null;
            res.topRight = null;
            res.bottomLeft = null;
            res.bottomRight = null;
        } else {
            res.isLeaf = false;
            res.val = false; // 非叶子节点 val 可以为任意值
        }

        return res;
    }
}
// @lc code=end

