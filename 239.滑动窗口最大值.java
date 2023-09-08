/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    // 维护一个单调队列，存储窗口内从窗口的最大值开始往后的依次大值
    // 或者说，每当一个数字从单调队列尾部进入的时候，都会从尾部开始顶掉所有比新数字小的数字
    // 队列中第一个就表示窗口内的最大值，第二个表示在窗口里第一个最大值后面的元素中的最大值，以此类推
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();

        // 最后转换为数组的时候，会用到索引，所以这里用ArrayList, 跟单调队列的实现是不同的
        List<Integer> res = new ArrayList<Integer>();

        // i表示窗口的右边界，在前k-1个的时候只会往窗口里加数据而不会更新最值
        for (int i = 0; i < nums.length; i++) {
            // 先把前k-1个元素放到窗口里
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                // 从第k个元素开始，此时窗口少一个元素，先加进去
                window.push(nums[i]);
                // 获取最值，放到结果里
                res.add(window.max());
                // 尝试把窗口左边的值从窗口里删掉，但如果即将离开窗口的这个数字不等于最值，
                // 那么这里实际不会删掉
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    class MonotonicQueue {
        // 这里都是在队列头尾操作，所以用LinkedList
        LinkedList<Integer> q = new LinkedList<Integer>();

        public void push(int n) {
            // 把比新数字小的数字都顶掉
            // 注意这里，如果原数字跟新数字相等，那么原数字不会被顶掉
            // 因为如果窗口里有两个相同的值都是最值，那么当第一个最值离开窗口的时候，
            // 他会从队列头部删掉，因此第二个最值此时还需要留在队列里
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            // 新数字放在队列尾部
            q.addLast(n);
        }

        public int max() {
            // 最大值始终是第一个
            return q.getFirst();
        }

        public void pop(int n) {
            // 尝试把一个数字从队列中删掉，结合主方法，调用该方法的时候表示窗口左侧要出去一个数字
            // 但是这个数字可能不是当前窗口的最大数字，所以要先判断，
            // 如果不相等，说明最大数字还在窗口里，那么就不能删
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

}
// @lc code=end

