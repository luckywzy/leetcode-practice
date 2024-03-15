package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1706 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution739 {
    /**
     * 创建一个单调递减栈，
     *   如果发现当前遍历的元素 temperatures[i] > 栈顶的元素temperatures[stack.peekFirst()]，
     *      那么就能知道 栈顶元素的 下一个更高温度是在哪天， result[stack.peekFirst()] = i - stack.peekFirst();
     *      同时把栈顶元素弹出
     *   同时在遍历的时候把元素 push 到栈里面
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                result[stack.peekFirst()] = i - stack.peekFirst();
                stack.removeFirst();
            }
            stack.push(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
