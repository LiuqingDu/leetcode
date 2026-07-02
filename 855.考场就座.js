/*
 * @lc app=leetcode.cn id=855 lang=javascript
 *
 * [855] 考场就座
 */

// @lc code=start
/**
 * @param {number} n
 */
var ExamRoom = function(n) {
    
    this.n = n;
    this.seats = []; // 保持升序排列的数组
};

/**
 * @return {number}
 */
ExamRoom.prototype.seat = function() {
    
    if (this.seats.length === 0) {
        this.seats.push(0);
        return 0;
    }

    let maxDist = 0;
    let studentSeat = 0;

    // 1. 考虑最左边 0 号座位
    let first = this.seats[0];
    if (first > 0) {
        maxDist = first;
        studentSeat = 0;
    }

    // 2. 遍历所有相邻座位，找中间最大距离
    for (let i = 0; i < this.seats.length - 1; i++) {
        let prev = this.seats[i];
        let next = this.seats[i + 1];
        let dist = Math.floor((next - prev) / 2);
        
        // 严格大于才更新，保证距离相同时选择编号更小的座位
        if (dist > maxDist) {
            maxDist = dist;
            studentSeat = prev + dist;
        }
    }

    // 3. 考虑最右边 n - 1 号座位
    let last = this.seats[this.seats.length - 1];
    if (this.n - 1 - last > maxDist) {
        studentSeat = this.n - 1;
    }

    // 4. 二分查找插入位置，保持数组有序
    let low = 0;
    let high = this.seats.length - 1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (this.seats[mid] < studentSeat) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    this.seats.splice(low, 0, studentSeat);

    return studentSeat;
};

/** 
 * @param {number} p
 * @return {void}
 */
ExamRoom.prototype.leave = function(p) {
    
    let index = this.seats.indexOf(p);
    if (index !== -1) {
        this.seats.splice(index, 1);
    }
};

/** 
 * Your ExamRoom object will be instantiated and called as such:
 * var obj = new ExamRoom(n)
 * var param_1 = obj.seat()
 * obj.leave(p)
 */
// @lc code=end

