/*
 * @lc app=leetcode.cn id=225 lang=javascript
 *
 * [225] 用队列实现栈
 */

// @lc code=start

var MyStack = function() {

    this.list1 = [];
    this.list2 = [];

};

/** 
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function(x) {

    while(this.list1.length) {
        this.list2.push(this.list1.pop());
    }
    this.list2.push(x);
};

/**
 * @return {number}
 */
MyStack.prototype.pop = function() {

    if (!this.list1.length) {
        while(this.list2.length) {
            this.list1.push(this.list2.pop());
        }
    }
    return this.list1.shift();
};

/**
 * @return {number}
 */
MyStack.prototype.top = function() {
    if (!this.list1.length) {
        while(this.list2.length) {
            this.list1.push(this.list2.pop());
        }
    }
    return this.list1[0];
};

/**
 * @return {boolean}
 */
MyStack.prototype.empty = function() {
    return !(this.list1.length + this.list2.length);
};

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
// @lc code=end

