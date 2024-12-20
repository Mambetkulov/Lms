package Models;


import database.GenerateId;

import java.util.HashMap;

public class Group {
    private Long id;
    private String description;
    private String name ;
    private HashMap<Long,Student> students;
    private HashMap<Long,Lesson> lessons;

    public Group( Long id ,String description ,String name, HashMap<Long,Student> students,HashMap<Long,Lesson> lessons) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.students = students;
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

    public HashMap<Long,Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Long,Student> students) {
        this.students = students;
    }

    public HashMap<Long, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(HashMap<Long,Lesson>  lessons) {
        this.lessons = lessons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "\nID - " + id +
                "\nNAME - " + name +
                "\nDESCRIPTION - " + description +
                "\n📖📖📖📖📖📖📖📖📖📖📖📖📖📖📖📖📖📖" ;
    }
}
