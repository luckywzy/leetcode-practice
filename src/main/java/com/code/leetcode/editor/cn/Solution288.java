package com.code.leetcode.editor.cn;

//单词的 缩写 需要遵循 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。 
//
// 以下是一些单词缩写的范例： 
//
// 
// dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母 
// internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母 
// it --> it 单词只有两个字符，它就是它自身的 缩写 
// 
//
// 
//
// 实现 ValidWordAbbr 类： 
//
// 
// ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象 
// boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
// 
// 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。 
// 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。 
// 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
//[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], [
//"cake"]]
//输出
//[null, false, true, false, true, true]
//
//解释
//ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", 
//"card"]);
//validWordAbbr.isUnique("dear"); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2
//r"，但这两个单词不相同
//validWordAbbr.isUnique("cart"); // 返回 true，字典中不存在缩写为 "c2t" 的单词
//validWordAbbr.isUnique("cane"); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2
//e"，但这两个单词不相同
//validWordAbbr.isUnique("make"); // 返回 true，字典中不存在缩写为 "m2e" 的单词
//validWordAbbr.isUnique("cake"); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2
//e" 的单词
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 3 * 10⁴ 
// 1 <= dictionary[i].length <= 20 
// dictionary[i] 由小写英文字母组成 
// 1 <= word <= 20 
// word 由小写英文字母组成 
// 最多调用 5000 次 isUnique 
// 
// Related Topics 设计 数组 哈希表 字符串 👍 14 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidWordAbbr {

    public ValidWordAbbr(String[] dictionary) {
        src = dictionary;
        map = new HashMap<>(src.length);

        for (int i = 0; i < src.length; i++) {
            String s = src[i];

            int idx = i;
            map.compute(make(s), (s1, oldValue) -> {
                if (oldValue == null) {
                    oldValue = new ArrayList<>();
                }

                oldValue.add(idx);
                return oldValue;
            });
        }

    }

    public boolean isUnique(String word) {
        String abbr = make(word);
        List<Integer> val = map.get(abbr);
        if (val == null) {
            return true;
        }

        for (Integer idx : val) {
            boolean equals = src[idx].equals(word);
            if (!equals) {
                return false;
            }
        }

        return true;
    }


    public String make(String word) {
        if (word.length() <= 2) {
            return word;
        }

        int suffLen = word.length() - 2;

        return word.substring(0, 1) + suffLen + word.substring(word.length() - 1) + "";
    }

    /**
     * key = 缩写
     * val = string[]的下标
     */
    Map<String, List<Integer>> map;
    String[] src;
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
