/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 递归解法看js版
        // 下面是迭代解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummp = new ListNode();
        dummp.next = head;
        ListNode slow = dummp;
        ListNode fast = slow.next;

        // 判断fast指向的值能否被加到列表里
        while (fast != null) {
            // 需要判断fast和fast.next的值
            // 如果fast后面还有相同数字，则把fast指向它们的最后一个上
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // 这里fast指向待处理的数字的最后一个元素上
            // 如果slow的下一个就是fast，说明fast这个数字只有一个，可以加入
            if (slow.next == fast) {
                slow = slow.next;
            } else {
                // 如果不是，说明fast的数字不能加入
                // slow.next 指向fast.next 就会把fast这些数字都跳过
                // 但是这里不移动slow，因为slow后面紧跟着的是fast后面的下一个数字，
                // 下一个数字还需要下一轮判断看是否可以加入，
                // 也就是slow指向的永远是已经确认加入队伍当中的
                slow.next = fast.next;
            }
            // 把fast指向它后面的下一个数字
            fast = fast.next;
        }

        return dummp.next;

    }
}
// @lc code=end

