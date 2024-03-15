package com.topicstring;

//去掉宇符串中连续出现大个0 的子串
public class RemoveKZeroSolution {

    public String removeKZero(String s, int k) {
        char[] chars = s.toCharArray();
        String res = "";
        int i = 0;
        //"a00b" k=2
        int left = 0;
        while (i < chars.length) {
            int start = i;
            while (i < chars.length && chars[i] == '0') {
                i++;
            }
            if ((i - start) == k) {
                res += s.substring(left, start);
                left = i;
            }else {
                i++;
            }
        }
        if(left < i){
            res += s.substring(left, chars.length);
        }

        return res;
    }

    public String removeKZero1(String s, int k) {
        char[] chars = s.toCharArray();
        String res = "";
        //"a00b" k=2
        int left = -1;
        int count = 0;
       for (int i = 0; i<chars.length; i++){
           if (chars[i] == '0'){
               count ++;
               left = left == -1 ? i: left;
           }else {
               if (count == k){
                   while (count-- != 0){
                       chars[left ++] = 0;
                   }
               }
               count = 0;
               left = -1;
           }
       }
       if (count == k){
           while (count-- != 0){
               chars[left ++] = 0;
           }
       }

        return String.valueOf(chars);
    }
}
