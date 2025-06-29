/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
    public int numComponents(ListNode head, int[] nums) {
        // 问题就是把nums中的元素在链表中找到并标记
        // 然后看被标记的有多少个连续的段
        // 那么统计有多少个这种段的起点即可
        // 起点就是: 前面没有元素, 或者前面的元素不在nums中
        // 用一个set来存储nums中的元素方便查找
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        // 前一个元素是否存在于set中
        boolean inSet = false;
        while (head != null) {
            // 如果当前元素在set中
            if (set.contains(head.val)) {
                // 如果前一个元素不在set中, 则说明这是一个新的段的起点
                if (!inSet) {
                    count++;
                }
                inSet = true; // 标记当前元素在set中
            } else {
                inSet = false; // 当前元素不在set中
            }
            head = head.next; // 移动到下一个节点
        }
        return count; // 返回段的数量
    }
}
// @lc code=end

