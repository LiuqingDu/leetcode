/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummp = new ListNode();
        ListNode cur = dummp;

        // 当两个链表均不会空的时候，比较两个链表头的小节点
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        // 判断哪个到头了，则把另一个剩下的部分直接拼在新链表后面
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }
        return dummp.next;
    }
}
// @lc code=end

