package com.code.leetcode.editor.cn;

//对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。 
//
// 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造
//目标字符串，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：source = "abc", target = "abcbc"
//输出：2
//解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
// 
//
// 示例 2： 
//
// 输入：source = "abc", target = "acdbc"
//输出：-1
//解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
// 
//
// 示例 3： 
//
// 输入：source = "xyz", target = "xzyxz"
//输出：3
//解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
// 
//
// 
//
// 提示： 
//
// 
// source 和 target 两个字符串都只包含 "a"-"z" 的英文小写字母。 
// source 和 target 两个字符串的长度介于 1 和 1000 之间。 
// 
// Related Topics 贪心 字符串 动态规划 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1055 {

    /**
     * 解法3：使用两个指针，sp, tp，使用 target[tp] 在source 找第一次出现的位置 pos ，
     *      1、找到的话，sp = pos +1，tp ++;继续找
     *      2、没找到，当前子序列无法匹配了，需要新的子序列了, pos重置，子序列数量++；
     * @param source
     * @param target
     * @return
     */
    public int shortestWay(String source, String target) {
        for (int i = 0; i < target.length(); i++) {
            if(!source.contains(target.charAt(i) +"")){
                return -1;
            }
        }
        int sp=0,tp=0;
        int res = 1;
        while (tp < target.length()){
            int index = source.indexOf(target.charAt(tp), sp);
            if(index > -1){
                sp = index + 1;
                tp ++;
            }else {
                res ++;
                sp = 0;
            }
        }
        return res;
    }



    /**
     * 解法1：生成source 字符串的所有子序列，然后回溯匹配target字符串，并记录下使用子串的数量，如果可以完全匹配，则记录长度 不可取
     * <p>
     * 解法2：如果source 中含有target 不存在的子序列，则不可以匹配，否则都可以匹配，
     * 设定dp[j]为当前匹配到target[j]时所需最短子序列：
     * 设定字符串tmp 为当前匹配到的字符串：
     * 1、如果tmp是source的子序列，那么dp[j] = dp[j-1]
     * 2、如果不是，那么dp[j] = dp[j-1] + 1,同时重新初始化tmp为target[j]
     *
     * @param source
     * @param target
     * @return
     */
    public int shortestWay2(String source, String target) {

        boolean[] exist = new boolean[26];
        for (int i = 0; i < source.length(); i++) {
            exist[source.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < target.length(); i++) {
            if (!exist[target.charAt(i) - 'a']) {
                return -1;
            }
        }

        int f1 = 1, f2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append(target.charAt(i));
            f2 = f1;
            if (!isSubSeq(sb.toString(), source)) {
                sb.setLength(0);
                sb.append(target.charAt(i));
                f2++;
            }
            f1 = f2;

        }
        return f1;
    }

    private boolean isSubSeq(String a, String source) {
        int l = 0;
        int aLen = a.length();
        if (a.length() > source.length()) {
            return false;
        }
        for (int i = 0; i < source.length(); i++) {
            if (l >= aLen) {
                break;
            }
            if (a.charAt(l) == source.charAt(i)) {
                l++;
            }
        }

        return l >= aLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
