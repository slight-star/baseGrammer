package com.dong.work;

public class StringUtil {

    private char[] chars;

    public StringUtil() {
    }

    public StringUtil(String str) {
        chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
    }

    /**
     * 获取字符串的长度
     *
     * @return 返回字符串的长度
     */
    public int length() {
        return chars.length;
    }

    /**
     * 查询字符在字符串中第一次出现的索引
     *
     * @param c 要查询的字符
     * @return 返回索引值，若返回正数，正数即为第一次出现的索引值；若返回负数，则代表在字符串中没有找到该字符
     */
    public int indexOf(char c) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    /**
     * 查询字符在字符串中最后一次出现的索引
     *
     * @param c 查询的字符
     * @return 返回索引值，若返回正数，正数即为最后一次出现的索引值；若返回负数，则代表在字符串中没有找到该字符
     */
    public int lastIndexOf(char c) {
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == c) {
                index = i;
                return index;
            }
        }
        return -1;
    }
}
