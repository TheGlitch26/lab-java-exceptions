package com.ironhack;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.age == person.age &&
                Objects.equals(this.name, person.name) &&
                Objects.equals(this.occupation, person.occupation);
    }

    @Override
    public int hashCode(){
        return Objects.hash(age, name, occupation);
    }

    @Override
    public String toString(){
        return getId() + "," + getName() + "," + getAge() + "," + getOccupation() + "\n";
    }
}
