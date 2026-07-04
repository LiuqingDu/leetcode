/*
 * @lc app=leetcode.cn id=558 lang=javascript
 *
 * [558] 四叉树交集
 */

// @lc code=start
/**
 * // Definition for a QuadTree node.
 * function _Node(val,isLeaf,topLeft,topRight,bottomLeft,bottomRight) {
 *    this.val = val;
 *    this.isLeaf = isLeaf;
 *    this.topLeft = topLeft;
 *    this.topRight = topRight;
 *    this.bottomLeft = bottomLeft;
 *    this.bottomRight = bottomRight;
 * };
 */

/**
 * @param {_Node} quadTree1
 * @param {_Node} quadTree2
 * @return {_Node}
 */
var intersect = function(quadTree1, quadTree2) {
    
    // 情况 1：t1 是叶子节点
    if (quadTree1.isLeaf) {
        return quadTree1.val ? quadTree1 : quadTree2;
    }
    
    // 情况 2：t2 是叶子节点
    if (quadTree2.isLeaf) {
        return quadTree2.val ? quadTree2 : quadTree1;
    }

    // 情况 3：两个都不是叶子节点，递归合并 4 个子区域
    const topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
    const topRight = intersect(quadTree1.topRight, quadTree2.topRight);
    const bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    const bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

    // 检查合并后的 4 个子节点是否可以压缩（均为叶子节点且值相同）
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
        && topLeft.val === topRight.val 
        && topLeft.val === bottomLeft.val 
        && topLeft.val === bottomRight.val) {
        
        return new Node(topLeft.val, true, null, null, null, null);
    }

    // 无法压缩，返回合并后的非叶子节点
    return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
};
// @lc code=end

