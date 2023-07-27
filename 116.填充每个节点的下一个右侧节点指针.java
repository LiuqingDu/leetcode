/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // 占用 O(n) 空间的方法
    // 依次遍历每一行，每行从右边往左遍历
    // 依次把当前节点的 next 指向前一个节点
    // 
    // public Node connect(Node root) {
    //     retraval(root);
    //     return root;
    // }
    // 
    // private void retraval(Node node) {
    //     if(node == null) {
    //         return;
    //     }
    //     Queue<Node> queue = new LinkedList<>();
    //     queue.add(node);
    //     while(!queue.isEmpty()) {
    //         int n = queue.size();
    //         Node pre = null;
    //         for (int i = 0; i < n; i++) {
    //             Node no = queue.poll();
    //             no.next = pre;
    //             pre = no;
    //             if (no.right != null) {
    //                 queue.offer(no.right);
    //             }
    //             if (no.left != null) {
    //                 queue.offer(no.left);
    //             }
    //         }
    //     }
    // }


    // 递归
    // 考虑两个相邻的节点，先将这两个节点连起来
    // 然后递归他们各自的左右节点，和【左节点的右节点+右节点的左节点】
    //         1
    //     (2     3)
    //   (4 [5) (6] 7)
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        link(root.left, root.right);
        return root;
    }
    private void link(Node l, Node r) {
        if (l == null || r == null) {
            return;
        }
        l.next = r;

        link(l.left, l.right);
        link(r.left, r.right);
        
        link(l.right, r.left);
    }
}
// @lc code=end

