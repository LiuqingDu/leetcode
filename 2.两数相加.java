/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 标记进位
        int ext = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // 直到两个链表都遍历完才结束
        while(l1 != null || l2 != null) {
            // 因为会按照更长的链表来遍历
            // 所以短的链表缺失的部分要当做 0
            l1 = l1 == null ? new ListNode(0) : l1;
            l2 = l2 == null ? new ListNode(0) : l2;
            // 求和，并更新进位数，然后把两个数字跟结果都向前挪一位
            ListNode node = new ListNode();
            int sum = ext + l1.val + l2.val;
            ext = sum >= 10 ? 1 : 0;
            node.val = sum%10;
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 这里要注意，上面只是走到了两个链表最后一位
        // 但如果最后一位算完之后还有进位，需要额外再补上
        if (ext == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return dummy.next;

    }
}
// @lc code=end

