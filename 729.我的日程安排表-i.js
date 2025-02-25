/*
 * @lc app=leetcode.cn id=729 lang=javascript
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start

var MyCalendar = function() {
    this.booked = [];
};

/** 
 * @param {number} startTime 
 * @param {number} endTime
 * @return {boolean}
 */
MyCalendar.prototype.book = function(startTime, endTime) {
    for (let arr of this.booked) {
        let l = arr[0], r = arr[1];
        if (endTime > l && startTime < r) {
            return false;
        }
    }
    this.booked.push([startTime, endTime]);
    return true;
};

/** 
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = new MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */
// @lc code=end

