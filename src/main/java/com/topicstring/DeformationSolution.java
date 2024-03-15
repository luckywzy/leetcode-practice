package com.topicstring;

import java.util.HashMap;
import java.util.function.BiFunction;

//判断两个字符串是否互为变形词
public class DeformationSolution {
    public boolean isDeformation(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }
        int[] map = new int[256];
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            map[c] ++;
        }
        for(int i = 0; i < s2.length(); i++){
            if (map[s2.charAt(i)] -- < 0){
                return false;
            }
        }
        return true;
    }
}
