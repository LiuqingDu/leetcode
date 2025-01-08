/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 先算出总共有多少个节点
        // 然后算出每份至少有多少个 n/k
        // 以及前多少份需要额外多一个 n%k

        ListNode[] result = new ListNode[k];
    
        // 计算链表的长度
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 计算每个部分的基础长度和多余节点数
        int partSize = length / k;
        int extraNodes = length % k;

        // 开始分割链表
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0); // 当前部分的长度

            // 遍历当前部分的长度，并断开链表
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) current = current.next;
            }

            // 断开当前部分
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }

            result[i] = partHead;
        }
        
        return result;
    }
}
// @lc code=end

