/*
 * @lc app=leetcode.cn id=622 lang=javascript
 *
 * [622] 设计循环队列
 */

// @lc code=start
/**
 * @param {number} k
 */
var MyCircularQueue = function(k) {

    this.queue = Array(k + 1);
    this.cap = k;
    this.head = 0;
    this.tail = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularQueue.prototype.enQueue = function(value) {

    if (this.isFull()) {
        return false;
    }

    this.queue[this.tail] = value;
    this.tail = (this.tail + 1) % (this.cap + 1);

    return true;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function() {

    if (this.isEmpty()) {
        return false;
    }

    this.head = (this.head + 1) % (this.cap + 1);

    return true;
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Front = function() {
    if (this.isEmpty()) {
        return -1;
    }

    return this.queue[this.head];
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function() {

    if (this.isEmpty()) {
        return -1;
    }

    return this.queue[(this.tail === 0 ? this.cap : this.tail - 1) % (this.cap + 1)];

};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function() {

    return (this.head === this.tail);
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function() {

    return (this.head === 0 && this.tail === this.cap) || (this.head - 1 === this.tail)
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
// @lc code=end

