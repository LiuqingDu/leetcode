/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        int n = t - 3000;
        while (queue.peek() < n) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

