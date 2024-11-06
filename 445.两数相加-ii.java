/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        // 将两个数字放入栈，然后从栈取出来依次相加
        // 加的时候新的数字放在链表头
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 将链表的节点值压入栈中
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;  // 结果链表的头节点
        int carry = 0;  // 进位

        // 逐个弹出栈中的节点值相加
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            carry = sum / 10;  // 更新进位
            int val = sum % 10;  // 当前节点的值

            // 创建新节点，将其插入到链表的头部
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}
// @lc code=end

