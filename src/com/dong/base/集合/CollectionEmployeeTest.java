package com.dong.base.集合;

import org.junit.Test;

import java.util.*;

public class CollectionEmployeeTest {




    @Test
    public void test(){
        Collection list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(new Integer(2));

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        HashSet set = new HashSet();
        set.add(11);
        set.add(22);
        System.out.println(set.toArray());
        for (Object o : set) {
            System.out.println(o);
        }
        Object[] arr = set.toArray();
        System.out.println(arr[0]);

        List<String> list1 = Arrays.asList("aa", "bb", "cc", "asd");
        System.out.println(list1);

    }
}

