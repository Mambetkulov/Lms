package Models;


import java.time.LocalDate;

public class Lesson {
   private Long id;
   private String name;
   private LocalDate data;


    public Lesson(Long id, String name, LocalDate data) {
        this.id = id;
        this.name = name;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return
                "\n🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫🏫" +
                "\nID - " + id +
                "\nNAME - " + name +
                "\nDATA - " + data
                ;
    }
}
