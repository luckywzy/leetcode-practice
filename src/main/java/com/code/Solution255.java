package com.code;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 * 示例 1：
 * <p>
 * 输入: [5,2,6,1,3]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [5,2,1,3,6]
 * 输出: true
 *
 * @author wangzongyu
 * @Description:
 * @date 2021/7/7 4:47 下午
 */
public class Solution255 {

    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        int lay = 1;
        for (int i = 1; i < len; i++) {
            if (Math.pow(2, i) > len) {
                lay = Math.pow(2, i) > len ? i : lay;
                break;
            }
        }

        int t = (int) Math.pow(2, lay);
        int layer = 1;
        int iter = 1;
        for (int i = 1; i <= len; i++) {

            if (i >= i + t / 2 || i > len / 2) {
                break;
            }
            // node > lNode
            if (i - 1 > i + 1 - 1 && preorder[i - 1] < preorder[i + 1 - 1]) {
                return false;
            }
            // node > rNode
            if (i - 1 < i + t / 2 - 1 && preorder[i - 1] > preorder[i + t / 2 - 1]) {
                return false;
            }

            iter++;
            if (iter >= Math.pow(2, layer)) {
                t = (int) Math.pow(2, lay - layer);
                layer++;
            }
        }
        return true;
    }
}
