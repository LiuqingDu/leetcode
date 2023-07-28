/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start

class MyQueue {

    // 维护两个栈，一个栈用于压入，一个用于弹出
    // 每次操作一个栈的时候要确保另一个栈的数据已经全部转入当前栈

    private Stack<Integer> stackPush = new Stack<Integer>();
    private Stack<Integer> stackPop = new Stack<Integer>();

    public MyQueue() {

    }
    
    public void push(int x) {
        // if (stackPush.isEmpty()) {
        //     while(!stackPop.isEmpty()) {
        //         stackPush.push(stackPop.pop());
        //     }
        // }
        // stackPush.push(x);

        // 上面的代码逻辑跟peek相反，压栈的时候把pop栈转移过来，
        // 但实际上，如果能确保peek()仅在pop栈为空的时候才将push栈转移过去
        // 那么push()可以不需要每次都先把pop栈的数据转移过来，直接入push栈就可以
        stackPush.push(x);
    }
    
    public int pop() {
        peek();
        return stackPop.pop();
    }
    
    public int peek() {
        // 弹出栈如果是空的，那么就从压入栈转移过来
        // 弹出栈如果非空，压入栈的数据不需要也不能转移过来，否则会打乱顺序
        if (stackPop.isEmpty()) {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

