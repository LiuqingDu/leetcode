/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    int[] queue;
    // 这个size比可用空间多一个，多出的用于放tail指针
    int size;
    // head 指向第一个元素位置
    int head = 0;
    // tail 指向最后一个元素的下一个位置
    int tail = 0;

    // 这里初始化的队列比需要的空间多一个，用来存储 tail
    // 注意size是实际的空间，比可用空间要多一个
    // 当空队列的时候就是head==tail
    // 满队列的时候就是tail是head前一个元素，一般是tail=head-1，或者head指向第一个且tail指向最后一个空间
    // 因为其他方法都取决于先判断队列是否为空或者满，所以先实现isEmpty和isFull

    public MyCircularQueue(int k) {
        size = k + 1;
        // 初始化的尺寸要多一个，因为tail要指向下一个位置，当队列满的时候，tail需要额外一个空间
        queue = new int[size];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        // 注意下面的这个计算方式，tail指向最后一个元素的下一个空间
        // 为防止tail - 1指针超出范围，可以往右挪一圈
        // 挪一圈应该是 + size
        return queue[(tail - 1 + size) % size];
    }
    
    // 空队列就是head和tail指向同一个位置，因为tail始终指向下一个位置
    public boolean isEmpty() {
        return head == tail;

    }
    
    // 满队列的情况一般是tail==head-1也就是tail在head左侧一个
    // 或者是head在开头，tail在末尾(size - 1)的位置
    public boolean isFull() {
        return (head == 0 && tail == size - 1) || (tail == head - 1);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

