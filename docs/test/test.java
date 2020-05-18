package com.lch;

import java.util.HashSet;
import java.util.Set;

public class test {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;//记录最长子串的长度
        int end = 0, start = 0;//记录开始和结尾的下标
        Set<Character> set = new HashSet<Character>();//使用set容器不重复
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {//如果窗口右侧的字符已经存在
                set.remove(s.charAt(start++));//左侧窗口边界向右
            } else {
                set.add(s.charAt(end++));//如果窗口中无重复，窗口右侧向右滑动
                res = Math.max(res, end - start);//同时记录当前最大长度
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
