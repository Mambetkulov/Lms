package Service;

import Models.Lesson;
import Models.Student;

import java.util.HashMap;
import java.util.HashSet;

public interface StudentService {

    void addNewStudent (Student student,String name);

    void updateStudent (Long id , Student newOne);

    Student findStudentByName(String name);

    HashMap<Long,Student> getAllStudentsByGroupName (String name);

    HashSet<Lesson> getAllStudentsLesson (Long id);

    void deleteStudent (String email);

    Student varify(String email ,String password);

    void getProfile(Student student);

    void getGroup (Student student);
}
