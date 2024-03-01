/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class Solution {

    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {

        // 这个给定的顺序实际上是中序遍历
        // 这题相当于从中序遍历还原为二叉树
        // 可以按照中序遍历的方式再把树还原出来

        if (head == null) {
            return null;
        }

        int c = 0;
        ListNode p = head;
        while (p != null) {
            c++;
            p = p.next;
        }

        cur = head;

        return buildTree(0, c - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = buildTree(start, mid - 1);

        TreeNode node = new TreeNode();
        node.val = cur.val;
        cur = cur.next;

        TreeNode right = buildTree(mid + 1, end);

        node.left = left;
        node.right = right;

        return node;
    }
}
// @lc code=end

