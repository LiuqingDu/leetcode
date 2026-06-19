/*
 * @lc app=leetcode.cn id=1438 lang=java
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        // 用于维护窗口内最大值的单调队列（从大到小）
        Deque<Integer> maxDeque = new LinkedList<>();
        // 用于维护窗口内最小值的单调队列（从小到大）
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;
        int maxLength = 0;
        
        // right 指针不断向右扩大窗口
        for (int right = 0; right < nums.length; right++) {
            
            // 1. 维持 maxDeque 的单调递减性：新来的数如果比队尾大，队尾的数就永远不可能成为最大值了，弹出！
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);
            
            // 2. 维持 minDeque 的单调递增性：新来的数如果比队尾小，队尾的数就永远不可能成为最小值了，弹出！
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);
            
            // 3. 检查当前窗口是否违反了限制：最大值 - 最小值 > limit
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // 如果左指针指向的元素正是当前的最大值或最小值，说明它要离开窗口了，从队列中移除
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                // 缩小窗口
                left++;
            }
            
            // 4. 此时窗口一定合法，更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
// @lc code=end

