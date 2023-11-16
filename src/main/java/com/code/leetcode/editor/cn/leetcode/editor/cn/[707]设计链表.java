package com.code.leetcode.editor.cn.leetcode.editor.cn;
//你可以选择使用单链表或者双链表，设计并实现自己的链表。
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类： 
//
// 
// MyLinkedList() 初始化 MyLinkedList 对象。 
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。 
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。 
// 
//
// Related Topics 设计 链表 👍 965 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    Node dummy;
    Node tail;
    int size;

    public MyLinkedList() {
        size = 0;
        dummy = new Node(0, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node node = dummy.next;
        while (index > 0) {
            node = node.next;
            index--;
        }

        return node.val;
    }

    public void addAtHead(int val) {
        Node oldNext = this.dummy.next;
        this.dummy.next = new Node(val, oldNext);
        this.size++;
    }

    public void addAtTail(int val) {
        Node node = this.dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(val, null);
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node node = this.dummy;
        while (index > 0) {
            node = node.next;
            index --;
        }

        Node oldNext = node.next;
        node.next = new Node(val, oldNext);
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node node = this.dummy;
        while (index > 0) {
            index--;
            node = node.next;
        }

        Node waitDelete = node.next;
        node.next = waitDelete.next;
        this.size--;
    }

//    public static void main(String[] args) {
//        MyLinkedList obj = new MyLinkedList();
//
//        obj.addAtHead(7);
//        obj.addAtHead(2);
//        obj.addAtHead(1);
//        obj.addAtIndex(3,0);
//        obj.deleteAtIndex(2);
//        obj.addAtHead(6);
//        obj.addAtTail(4);
//        obj.get(4);
//        obj.addAtHead(4);
//        obj.addAtIndex(5,0);
//        obj.addAtHead(6);
//    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
