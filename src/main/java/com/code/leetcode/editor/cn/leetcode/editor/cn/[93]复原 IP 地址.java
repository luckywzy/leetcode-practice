package com.code.leetcode.editor.cn.leetcode.editor.cn;//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1367 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    //TODO not run
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        List<String> path = new ArrayList<>();
        bt(s, 0, 0, path, result);
        return result;
    }

    void bt(String s, int startIndex, int spiltTimes, List<String> path, List<String> result) {
        if (startIndex == s.length()) {
            if (spiltTimes == 4) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (startIndex + i >= s.length()) {
                break;
            }
            if (isValid(s, startIndex, startIndex + i)) {
                path.add(s.substring(startIndex, startIndex + i+1));
                bt(s, startIndex + i + 1, spiltTimes + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isValid(String s, int i, int j) {
        if (i >= j) {
            return false;
        }
        int len = j - i + 1;
        if (len > 1 && s.charAt(i) == '0') {
            return false;
        }
        int val = Integer.parseInt(s.substring(i, j));
        return val <= 255;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
