package com.code.leetcode.editor.cn;

//请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。 
//
//
// 1 号机（发送方）有如下函数： 
//
// string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//} 
//
// 2 号机（接收方）有如下函数： 
//
// vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
// 
//
// 1 号机（发送方）执行： 
//
// string encoded_string = encode(strs);
// 
//
// 2 号机（接收方）执行： 
//
// vector<string> strs2 = decode(encoded_string);
// 
//
// 此时，2 号机（接收方）的 strs2 需要和 1 号机（发送方）的 strs 相同。 
//
// 请你来实现这个 encode 和 decode 方法。 
//
// 注意： 
//
// 
// 因为字符串可能会包含 256 个合法 ascii 字符中的任何字符，所以您的算法必须要能够处理任何可能会出现的字符。 
// 请勿使用 “类成员”、“全局变量” 或 “静态变量” 来存储这些状态，您的编码和解码算法应该是非状态依赖的。 
// 请不要依赖任何方法库，例如 eval 又或者是 serialize 之类的方法。本题的宗旨是需要您自己实现 “编码” 和 “解码” 算法。 
// 
// Related Topics 设计 数组 字符串 👍 59 👎 0


import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution271 {

    /**
     * 实际上的编解码 需要转换为二进制 数据传输
     * 这里只需要转换为 string 即可
     * 关键的问题：1、数据的长度表示；2、数据的分割
     * 解法：长度可以用定长的数据表示，例如int用4个char表示，那么就不需要分割了，因为知道长度后直接取指定长度，就是数据内容
     * 问题：如何用char数组表示int？
     * @param strs
     * @return
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        int size = strs.size();
        char[] len = intToCharArr(size);
        sb.append(len);
        for (String str : strs) {
            sb.append(intToCharArr(str.length()));
            sb.append(str);
        }
        return sb.toString();
    }

    private char[] intToCharArr(int size) {
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (size >> (i * 8) & 0xff);
        }
        return bytes;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String substring = s.substring(0, 4);
        int len = stringToInt(substring);
        List<String> res = new ArrayList<>(len);

        int idx = 4;
        while (idx < s.length()) {
            int size = stringToInt(s.substring(idx, idx + 4));
            idx = idx + 4;
            String data = s.substring(idx, idx + size);
            res.add(data);
            idx = idx + size;
        }
        return res;
    }

    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray())
            result = (result << 8) + (int) b;
        return result;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)
