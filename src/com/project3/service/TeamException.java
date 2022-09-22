package com.project3.service;

/**
 * 自定义异常类  一般继承于Exception(可能编译时就报错) 或 RuntimeException（编译时不报错，运行时报错）
 */
public class TeamException extends Exception {
    // 创建一个唯一ID
    static final long serialVersionUID = -33875169948L;

    // 提供构造器
    public TeamException() {
    }

    // 提供一个带参构造器
    public TeamException(String message) {
        super(message);
    }
}
