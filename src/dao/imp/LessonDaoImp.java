package dao.imp;
import Models.Group;
import Models.Lesson;
import Models.Student;
import dao.LessonDao;
import database.DataBase;
import database.GenerateId;
import java.util.HashMap;
import java.util.Map;


public class LessonDaoImp implements LessonDao {

    @Override
    public void addLesson(Lesson lesson,String name) {
        Long copy = GenerateId.generateIdL();
        for(Map.Entry<Long,Group> entry : DataBase.groups.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                lesson.setId(copy);
                entry.getValue().getLessons().put(copy, lesson);
                System.out.println("SUCCESSFULLY ADDED");
                if (entry.getValue().getStudents() != null){
                    for (Map.Entry<Long, Student> student : entry.getValue().getStudents().entrySet()) {
                        student.getValue().getLessons().add(lesson);
                    }
            }
            }
        }
        }


    @Override
    public Lesson getLessonByName(String name) {
        for(Map.Entry<Long,Group> entry : DataBase.groups.entrySet()){
            for(Map.Entry<Long,Lesson> lesson : entry.getValue().getLessons().entrySet()){
                if(lesson.getValue().getName().equals(name)){
                    return lesson.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public HashMap<Long, Lesson> getAllLessonsByGroupName(String name) {
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
            if(entry.getValue().getName().equals(name)){
                return entry.getValue().getLessons();
            }
        }
        return null;
    }

    @Override
    public void deletaLesson(Long id) {
        boolean turnOff = true;
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
            for(Map.Entry<Long,Lesson> lesson : entry.getValue().getLessons().entrySet()){
                if(lesson.getKey().equals(id)){
                    entry.getValue().getLessons().remove(id);
                    System.out.println("SUCCESSFULLY DELETED");
                    turnOff = false;
                    break;
                }
            }
        }
        if(turnOff) System.out.println("LESSON WITH ID NOT FOUND");
    }
}
