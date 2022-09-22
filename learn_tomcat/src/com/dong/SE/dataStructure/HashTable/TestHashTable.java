package com.dong.SE.dataStructure.HashTable;

/**
 * @author dfx
 */
public class TestHashTable {
    public static void main(String[] args) {
        StuInfo stuInfo1 = new StuInfo(15, 3);
        StuInfo stuInfo2 = new StuInfo(16, 5);
        StuInfo stuInfo3 = new StuInfo(26, 3);
        StuInfo stuInfo4 = new StuInfo(25, 9);
        StuInfo stuInfo5 = new StuInfo(13, 8);
        StuInfo stuInfo6 = new StuInfo(14, 7);

        HashTable hashTable = new HashTable();

        hashTable.put(stuInfo1);
        hashTable.put(stuInfo2);
        hashTable.put(stuInfo3);
        hashTable.put(stuInfo4);
        hashTable.put(stuInfo5);
        hashTable.put(stuInfo6);

        System.out.println(hashTable);
        //想要获取的目标数据
        //得到15岁的有多少个
        StuInfo target = new StuInfo(15);
        System.out.println(target);
        System.out.println(hashTable.get(target));
    }
}
