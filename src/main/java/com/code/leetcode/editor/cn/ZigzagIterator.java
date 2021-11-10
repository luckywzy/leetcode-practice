package com.code.leetcode.editor.cn;

//给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。 
//
// 示例: 
//
// 输入:
//v1 = [1,2]
//v2 = [3,4,5,6] 
//
//输出: [1,3,2,4,5,6]
//
//解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
//     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。 
//
// 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢? 
//
// 拓展声明： 
// “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如： 
//
// 输入:
//[1,2,3]
//[4,5,6,7]
//[8,9]
//
//输出: [1,4,8,2,5,9,3,6,7].
// 
// Related Topics 设计 队列 数组 迭代器 👍 47 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class ZigzagIterator {

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        Integer val;
        if ((pos1 + pos2) % 2 == 0) {
            if (pos1 < v1.size()) {
                val = v1.get(pos1);
                pos1++;
            } else {
                val = v2.get(pos2);
                pos2++;
            }

        } else {
            if (pos2 < v2.size()) {
                val = v2.get(pos2);
                pos2++;
            } else {
                val = v1.get(pos1);
                pos1++;
            }
        }
        return val;
    }

    public boolean hasNext() {
        return pos1 + pos2 < v1.size() + v2.size();
    }

    int pos1 = 0;
    int pos2 = 0;
    List<Integer> v1;
    List<Integer> v2;

    /**
     * 进阶：
     * K个数组，klist
     * 使用pos[k-1] 来表示 第K 个数组遍历到的位置
     * 使用 point 指向 当前遍历到的数组
     * 使用 total 表示数据总长度
     * hasNext 需要汇总一下 pos[0,,,k-1]的和 与total 的大小
     * next 需要判断当前point指向的数组是否未遍历完，
     *      否，point 取下一个数组，
     *      是则取当前的 kList.get(point).get(posTablek[point])， 同时自增 posTablek[point]， point
     *      注：point >= k 时 需要 将 point 重置为0
     */
    public static class ZigzagIteratorK {
        List<List<Integer>> kList;

        public ZigzagIteratorK(List<List<Integer>> kList) {
            this.kList = kList;
            posTablek = new int[kList.size()];
            for (List<Integer> list : kList) {
                total += list.size();
            }
        }

        public boolean hasNext() {
            int p = 0;
            for (int pos : posTablek) {
                p += pos;
            }
            return p < total;
        }

        public int next() {
            int point1 = point;
            //posTablek[point1] 当前指向的数组指向的pos
            while (posTablek[point1] >= kList.get(point1).size()) {
                point1++;
                if (point1 >= posTablek.length) {
                    point1 = 0;
                }
            }
            Integer val = kList.get(point1).get(posTablek[point1]);
            posTablek[point1]++;
            point++;
            if (point >= posTablek.length) {
                point = 0;
            }
            return val;
        }

        //list指向的pos
        int[] posTablek;
        //当前指向的list
        int point;
        int total;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
