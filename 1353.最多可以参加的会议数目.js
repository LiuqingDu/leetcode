/*
 * @lc app=leetcode.cn id=1353 lang=javascript
 *
 * [1353] 最多可以参加的会议数目
 */

// @lc code=start
/**
 * @param {number[][]} events
 * @return {number}
 */
var maxEvents = function(events) {
    // 按开始时间排序
    events.sort((a, b) => a[0] - b[0]);

    // 小根堆（存结束时间）
    class MinHeap {
        constructor() {
            this.heap = [];
        }

        size() {
            return this.heap.length;
        }

        peek() {
            return this.heap[0];
        }

        offer(val) {
            this.heap.push(val);
            this.shiftUp(this.heap.length - 1);
        }

        poll() {
            if (this.heap.length === 1) {
                return this.heap.pop();
            }

            const top = this.heap[0];
            this.heap[0] = this.heap.pop();
            this.shiftDown(0);

            return top;
        }

        shiftUp(index) {
            while (index > 0) {

                let parent = Math.floor((index - 1) / 2);

                if (this.heap[parent] <= this.heap[index]) {
                    break;
                }

                [this.heap[parent], this.heap[index]] =
                [this.heap[index], this.heap[parent]];

                index = parent;
            }
        }

        shiftDown(index) {

            let n = this.heap.length;

            while (true) {

                let smallest = index;
                let left = index * 2 + 1;
                let right = index * 2 + 2;

                if (
                    left < n &&
                    this.heap[left] < this.heap[smallest]
                ) {
                    smallest = left;
                }

                if (
                    right < n &&
                    this.heap[right] < this.heap[smallest]
                ) {
                    smallest = right;
                }

                if (smallest === index) {
                    break;
                }

                [this.heap[index], this.heap[smallest]] =
                [this.heap[smallest], this.heap[index]];

                index = smallest;
            }
        }
    }

    const pq = new MinHeap();

    let n = events.length;
    let i = 0;
    let ans = 0;

    // 最大结束日期
    let maxDay = 0;

    for (const [s, e] of events) {
        maxDay = Math.max(maxDay, e);
    }

    // 枚举每天
    for (let day = 1; day <= maxDay; day++) {

        // 加入今天开始的会议
        while (i < n && events[i][0] === day) {
            pq.offer(events[i][1]);
            i++;
        }

        // 删除已经过期的会议
        while (pq.size() && pq.peek() < day) {
            pq.poll();
        }

        // 参加结束最早的会议
        if (pq.size()) {
            pq.poll();
            ans++;
        }
    }

    return ans;
};
// @lc code=end

