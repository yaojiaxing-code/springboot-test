package cn.practice.test.domian;

import java.util.Comparator;

public class People2 implements Comparator<People2>{
    private int age;
    private String name;

    public People2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compare(People2 o1, People2 o2) {
        /*if(o1.getAge()<o2.getAge()){
                    return 1;
                }else if(o1.getAge()==o2.getAge()){
                    return 0;
                }else {
                    return -1;
                }*/
        return o1.getAge()-o2.getAge();
    }
}
