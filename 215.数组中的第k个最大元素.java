/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 优先队列默认是从小到大，传入自定义的comparator可以实现从大到小
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // 依次往队列里放东西，如果size>k则把头部的推出，这样队列里始终有最大的k个数
        // 其中第一个就是第k大的
        // 优先队列的实现方式是最小堆
        for (int num: nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
// @lc code=end

