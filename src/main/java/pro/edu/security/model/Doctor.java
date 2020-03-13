package pro.edu.security.model;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Doctor {
    private String id;
    private  String name;
    private  int age;

    public Doctor() {
    }

    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Doctor(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor person = (Doctor) o;
        return getId().equals(person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("id", this.id)
                .add("name",this.name)
                .add("age",this.age)
                .toString();
    }

}
