package com.code;

import java.util.ArrayList;
import java.util.List;

class Vector2D_251 {

    List<Integer> list;
    int index;

    public Vector2D_251(int[][] vec) {
        list = new ArrayList<>(vec.length);
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                list.add(vec[i][j]);
            }
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public static void main(String[] args) {
        //Vector2D obj = new Vector2D(new int[][]{{1,2},{3}, {4}});
        Vector2D_251 obj = new Vector2D_251(new int[][]{});
        int next = obj.next();
        boolean hasNext = obj.hasNext();
        System.out.println(next + "" + hasNext);
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 * <p>
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * <p>
 * iterator.next(); // 返回 1
 * iterator.next(); // 返回 2
 * iterator.next(); // 返回 3
 * iterator.hasNext(); // 返回 true
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 4
 * iterator.hasNext(); // 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-2d-vector
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */