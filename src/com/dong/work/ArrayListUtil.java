package com.dong.work;

public class ArrayListUtil {

    public Object[] ElementData;
    public int Size = 0;
    public Object obj;

    public ArrayListUtil() {
        super();
        ElementData = new Object[10];
    }

    public ArrayListUtil(Object[] ElementData, int size) {
        super();
        this.ElementData = ElementData;
        Size = size;
    }

    /**
     * 将元素添加到 arraylist 的末尾
     *
     * @param obj 被添加的元素
     */
    public void add(Object obj) {
        if (Size >= ElementData.length) {
            Object[] t = new Object[ElementData.length * 2];
            System.arraycopy(ElementData, 0, t, 0, ElementData.length);
            ElementData = t;
        }
        ElementData[Size++] = obj;
    }

    /**
     * 返回 arraylist 里元素的数量
     *
     * @return 返回元素数量
     */
    public int size() {
        return Size;
    }

    /**
     * 设置 arraylist 集合的大小
     *
     * @param size 集合的大小
     */
    public void setSize(int size) {
        Size = size;
    }

    /**
     * 通过索引值获取 arraylist 中的元素
     *
     * @param Index 要获取元素的索引
     * @return 返回该索引位置的元素
     */
    public Object get(int Index) {
        return ElementData[Index];
    }

    /**
     * 判断存储的元素是否相等
     *
     * @param obj 要比较的对象
     * @return 返回ture代表相等，返回false代表不等
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * 判断 arraylist 是否为空
     *
     * @return 返回ture代表集合为空，返回false代表集合非空
     */
    public boolean isEmpty() {
        return Size == 0;
    }

    /**
     * 删除 arraylist 中的所有元素
     */
    public void clear() {
        for (int i = 0; i < size(); i++) {
            ElementData[i] = null;
        }
        Size = 0;
    }
}
