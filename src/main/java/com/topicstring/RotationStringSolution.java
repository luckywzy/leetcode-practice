package com.topicstring;

//判断两个字符串是否互为旋转词
public class RotationStringSolution {

    public boolean isRotation(String a, String b){
        //"cdab" "abcd"

        // "abcdabcd"
        //生成一个大的 B2 字符串，B2 是b+b，那么B2 中如果包含a 则 互为旋转词
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        String b2 = b + b;
        return  b2.contains(a);
    }
}
