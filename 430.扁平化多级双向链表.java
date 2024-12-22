/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        // 递归是比较容易想到的方法
        // 创建一个虚拟节点避免空节点问题
        Node dummy = new Node();
        dummy.next = head;
        while (head != null) {
            // 如果当前节点没有孩子节点则跳过
            if (head.child == null) {
                head = head.next;
            } else {
                // 记录下一个节点,在处理完孩子节点后,
                // 需要把这个下一个节点拼接到孩子之后
                Node tmp = head.next;
                // 把孩子节点递归展开成平的, 获取孩子的头结点
                Node childHead = flatten(head.child);
                // 把孩子拼接到当前节点后
                head.next = childHead;
                childHead.prev = head;
                head.child = null;

                // 这里孩子已经拼接到当前节点之后了
                // 一直往后寻找到孩子展开后的末尾
                // 孩子节点展开后末尾是没有节点的
                while (head.next != null) {
                    head = head.next;
                }
                // 把孩子的末尾接上之前的下一个节点
                head.next = tmp;
                // 如果拼接后的下一个节点是一个真实节点
                // 则还要处理 prev 指针
                if (tmp != null) {
                    tmp.prev = head;
                }
                // 无论是不是真实节点,都要前进一步
                head = tmp;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

