/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start

class MyStack {

    private Queue<Integer> queue = new LinkedList<Integer>();

    public MyStack() {

    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    // 要查看栈的顶，也就是查看队列尾部
    // 可以将队列前size-1个元素依次取出并放入队列尾部，
    // 这样队列第一个元素是模拟的栈顶元素，用完以后再放回队列尾部还原
    // 也可以在push和pop方法中随时维护一个变量指向栈顶
    public int pop() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int r = queue.poll();
        return r;
    }
    
    public int top() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int r = queue.peek();
        queue.offer(queue.poll());
        return r;

    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

