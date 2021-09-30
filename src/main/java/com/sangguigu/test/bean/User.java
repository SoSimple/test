package com.sangguigu.test.bean;

/**
 * @author qjh
 */
public class User {
    private String Name;
    private int age;
    private Pet pet;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int age) {
        Name = name;
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User(String name, int age, Pet pet) {
        Name = name;
        this.age = age;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
