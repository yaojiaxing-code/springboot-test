package cn.practice.test;

import cn.practice.test.domian.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class testComparable {
    public static void main(String[] args) {
        People people = new People(18,"张三");
        People people1 = new People(16,"李四");
        People people2 = new People(25,"赵柳");
        People people3 = new People(25,"姚九");
        ArrayList<People> list = new ArrayList<People>();
        list.add(people);
        list.add(people1);
        list.add(people3);
        list.add(people2);
        System.out.println(list);

        /*list.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                *//*if(o1.getAge()<o2.getAge()){
                    return 1;
                }else if(o1.getAge()==o2.getAge()){
                    return 0;
                }else {
                    return -1;
                }*//*
                return o1.getAge()-o2.getAge();
            }
        });*/

        System.out.println(list);
        System.out.println("=====================");

        /*
        Exception in thread "main" java.lang.ClassCastException:
        [Ljava.lang.Object; cannot be cast to [Lcn.practice.test.domian.People;
        */
//        People[] array = (People[]) list.toArray();

        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
