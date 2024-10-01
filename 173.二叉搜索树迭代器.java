/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        // 二叉搜索树的中序遍历就是有序的
        // 题目意思其实就是每次调用 next() 的时候，根据中序遍历返回下一个数字
        // 简单的方法是把中序遍历存成链表来访问
        // 也可以用栈来提升效率
        // 中序遍历是先进入当前节点，但不访问值，先访问左值然后再访问自己
        // 这种先进入，但后续才真正访问的，用栈就可以实现，先把自己压入栈，
        // 后面出栈到自己的时候，在出栈访问自己
        // 观察树的中序遍历，用[]表示进入（入栈），用{}表示访问值（出栈）

        //       7
        //   3          15
        //         9
        //           11

        // [7] - [3] - {3} - {7} -[15] - [9] - {9} - [11] - {11} - {15}

        // 可以看出，优先访问左节点到最深，然后弹出一个左节点，访问它，
        // 然后访问它的右节点，这一个右节点后继续深度访问左节点
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        TreeNode node = cur.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

