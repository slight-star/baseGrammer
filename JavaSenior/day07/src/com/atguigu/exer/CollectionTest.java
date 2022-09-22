package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * @author shkstart
 * @create 2019 上午 9:36
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);
    }


    //练习：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }

        List list1 = Collections.synchronizedList(list);
    }

    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);

    }


    @Test
    public void test4(){
        Scanner sc = new Scanner(System.in);
        List list = new ArrayList();
        for (int i = 0; i<10; i++){
            System.out.println("请输入第"+(i+1)+"个数");
            int num = 0;
            try {
                num = sc.nextInt();
            } catch (ClassCastException e) {
                // TODO: handle exception
                System.out.println("您输入的数值有误");
            }
            list.add(num);
        }

        System.out.println("倒序输出数字");
        Collections.reverse(list);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("从小到大输出数字");
        Collections.sort(list);
        Iterator iterator1 = list.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("从大到小输出数字");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1,i2);
                }
                throw new RuntimeException("您输入的数据有误");
            }
        });
        Iterator iterator2 = list.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

    @Test
    public void test5(){
        TreeSet<Student> stuSet = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的姓名与分数，当输入为负数时，结束输入");
        for(int i = 0;;i++){
            System.out.println("请输入第"+(i+1)+"个学生的姓名：");
            String name = sc.next();
            System.out.println("请输入第"+(i+1)+"个学生的分数：");
            int score = sc.nextInt();
            if (score < 0){
                break;
            }else{
                stuSet.add(new Student(name,score));
            }
        }

        System.out.println("遍历学生姓名和分数：");
        for (Student stu : stuSet){
            System.out.println(stu.getName() + "---->" + stu.getScore());
        }

        List<Student> stuList = new ArrayList();
        stuList.addAll(stuSet);
        Collections.sort(stuList);

        System.out.println("按照分数显示前三名学员的名字:");
        int count = 0;
        for(Student stu: stuList){
            if (count < 3){
                System.out.println(stu.getName() + "---->" + stu.getScore());
            }else{
                break;
            }
            count++;
        }
    }

    @Test
    public void test6() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(new File("src/com/dong/base/集合/text.txt")));

        HashMap<String,Integer> map = new HashMap<>();
        String str;
        while((str=br.readLine())!=null){
            System.out.println(str);
            char ch = str.charAt(0);
            String key = String.valueOf(ch);
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key,value+1);
            }else{
                map.put(key,1);
            }
        }

        for (String s : map.keySet()) {
            System.out.println(s + "--->" + map.get(s));
        }
    }


    @Test
    public void test7() throws FileNotFoundException {
        File file = new File("src/com/dong/base/集合/Employee.java");
        Scanner sc = new Scanner(file);
//        HashMap<String,Integer> map = new HashMap();
        HashSet set = new HashSet();
        set.add("import");
        set.add("public");
        set.add("static");
        int count = 0;
        while(sc.hasNext()){
            String word = sc.next();
//            if (map.containsKey(word)){
//                int value = map.get(word);
//                map.put(word,value+1);
//            }else{
//                map.put(word,1);
//            }
            if (set.contains(word)){
                count++;
            }
        }
        System.out.println(count);

//        for (String s : map.keySet()){
//            System.out.println(s + "--->" + map.get(s));
//        }

    }

    @Test
    public void test9(){
        Integer[] datas = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(datas);
        list.add(5);
        System.out.println(list.size());

        
    }

}



class Student implements Comparable{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student stu = (Student) o;
            int num = stu.getScore() - this.getScore() ;
            if(num != 0){
                return num;
            }else{
                return this.getName().compareTo(stu.getName());
            }
        }
        throw new RuntimeException("您输入的数据类型有误");
    }
}