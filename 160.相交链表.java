/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 分别在两条链表尾部拼接另一条链表，形成下面的形状，其中 a，b 为前面不重叠部分
        // o 为交点，c 为后续重叠部分
        // a a a a o c c b b o c c
        //     b b o c c a a a a o c c
        // 把两条链表对齐
        // a a a a o c c b b o c c
        // b b o c c a a a a o c c
        // 可以发现这样同时前进，他们会在第二个交点处相遇
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA!=curB) {
            // 如果第一条链表走到尽头，则沿着第二条继续走
            if (curA==null) {
                curA=headB;
            } else {
                // 往前走一步
                curA = curA.next;
            }
            // 如果第二条走到尽头则沿着第一条继续
            if (curB==null) {
                curB=headA;
            } else {
                curB = curB.next;
            }
            // 如果有交点则会在第二个交点相遇，如果没有交点
            // 则各自走完对方的路之后就会同时走到 null
        }
        return curA;
    }
}
// @lc code=end

