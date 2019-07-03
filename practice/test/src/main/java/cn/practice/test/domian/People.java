package cn.practice.test.domian;

public class People implements Comparable<People>{
    private int age;
    private String name;

    public People(int age, String name) {
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
    public int compareTo(People o) {
        if(this.age<((People)o).getAge()){
            return -1;
        }else if(this.age==((People)o).getAge()){
            //return this.name.compareToIgnoreCase(o.getName());
            return o.getName().compareToIgnoreCase(this.name);
        }else {
            return 1;
        }
        //return o.getAge()-this.getAge();
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
