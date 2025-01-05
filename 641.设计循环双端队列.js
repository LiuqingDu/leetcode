/*
 * @lc app=leetcode.cn id=641 lang=javascript
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
/**
 * @param {number} k
 */
var MyCircularDeque = function(k) {
    this.capacity = k;
    this.deque = new Array(k);
    this.front = 0;
    this.rear = k - 1;
    this.size = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
    if (this.isFull()) {
        return false;
    }
    this.front = (this.front - 1 + this.capacity) % this.capacity;
    this.deque[this.front] = value;
    this.size++;
    return true;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
    if (this.isFull()) {
        return false;
    }
    this.rear = (this.rear + 1) % this.capacity;
    this.deque[this.rear] = value;
    this.size++;
    return true;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
    if (this.isEmpty()) {
        return false;
    }
    this.front = (this.front + 1) % this.capacity;
    this.size--;
    return true;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
    if (this.isEmpty()) {
        return false;
    }
    this.rear = (this.rear - 1 + this.capacity) % this.capacity;
    this.size--;
    return true;
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
    if (this.isEmpty()) {
        return -1;
    }
    return this.deque[this.front];
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
    if (this.isEmpty()) {
        return -1;
    }
    return this.deque[this.rear];
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
    return this.size === 0;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
    return this.size === this.capacity;
};

/** 
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
// @lc code=end

