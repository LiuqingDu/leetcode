/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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

    // 这题属于数学题，如何在长度未知的序列（数据流）中随机选择一个元素出来？
    // 结论：当你遇到第 i 个元素时，应该有 1/i 的概率选择该元素，1 - 1/i 的概率保持原有的选择。

    // 此题描述不太好，它想考察蓄水池解法
    // 此题主要是在于只取一次随机数的话，最佳方案是什么？
    // 尽量只遍历一次，空间占用也要最小
    // 那么就需要在遍历的过程中确保每个数字取到的概率相等
    // 假设只有一个数字，那么取到它的概率为1；如果有两个数字，每个数字概率0.5，以此类推
    // 那么我们可以记录一个当前的取值，当遍历到第一个数字的时候，该数字的概率为1，那么取值记为第一个数字
    // 当遍历到第二个数字的时候，这个数字的概率为0.5，那么我们生成一个1到2的随机数，如果结果为2（概率0.5），
    // 那么就把取值改为第二个数字，否则就不改。
    // 这样，很明显即使是遍历了这两个数字，进行了两次取值，但是取两个值的概率都是0.5
    // 继续取第三个数，随机一个1到3的数，如果结果为3，那么就取值改为第三个数，否则不改
    // 这里不改变的概率为2/3，改变的概率为1/3。如果不改变，那么这个不变的数字来源于1或者2，且它们分别占这2/3概率的一半，也就是1/3
    // 以此类推，取第n个数字就进行1到n的随机数，这样使得每个数字的取值概率都是均等的1/n

    private ListNode head;
    Random r = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int res = 0;
        int n = 0;
        // 设定一个指针指向当前位置
        ListNode cur = head;
        while(cur!=null) {
            n++;
            // nextInt(x) 是含0不含n的整数，+1后变为含1含n不含n+1的整数
            int i = r.nextInt(n) + 1;
            // 如果随即出来的数字等于当前的n，概率为1/n，那么就更新结果
            // 也可以直接 if (0 == r.nextInt(n)) 随机一个[0,n)的数，该数等于0的概率为1/n
            if (i == n) {
                res = cur.val;
            }
            // 继续下一个节点
            cur = cur.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

