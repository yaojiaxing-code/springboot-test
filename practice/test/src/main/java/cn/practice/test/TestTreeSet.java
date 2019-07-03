package cn.practice.test;

import cn.practice.test.domian.People;
import cn.practice.test.domian.People2;

import java.util.Comparator;
import java.util.TreeSet;

/*
* TreeSet在存储时会先比较大小再存储，大小相同则认为元素相同不存储
* */
public class TestTreeSet {
    public static void main(String[] args) {
        People people = new People(18,"张三");
        People people1 = new People(16,"李四");
        People2 people2 = new People2(25,"赵柳");
        People2 people3 = new People2(27,"姚九");
        TreeSet<People> treeSet = new TreeSet<People>();
        treeSet.add(people);
        treeSet.add(people1);
        System.out.println(treeSet);

        //如果compare方法返回0，则不存储当前元素
        TreeSet<People2> treeSet2 = new TreeSet<People2>(new Comparator<People2>() {
            @Override
            public int compare(People2 o1, People2 o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        //必须实现comparable接口才能存入treeSet中
        //TreeSet<People2> treeSet2 = new TreeSet<>();
        treeSet2.add(people2);
        treeSet2.add(people3);
        System.out.println(treeSet2);


    }
}
