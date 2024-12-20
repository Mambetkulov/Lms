package Models;

import java.util.HashSet;

public class Student {
    private Long id ;
    private String name ;
    private String surname;
    private int age ;
    private String email;
    private String password;
    private HashSet<Lesson> lessons;


    public Student(Long id, String name, String surname,
                   int age, String email, String password,  HashSet<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public HashSet<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Lesson lessons) {
        this.lessons.add(lessons);
    }

    @Override
    public String toString() {
        return "\n🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓" +
                "\nID - " + id +
                "\nNAME - " + name +
                "\nSURNAME - " + surname +
                "\nAGE - " + age +
                "\nEMAIL - " + email +
                "\nPASSWORD - " + password

                ;
    }
}
