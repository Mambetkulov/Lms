package Service.imp;
import Models.Lesson;
import Models.Student;
import Service.StudentService;
import dao.imp.StudentDaoImp;
import java.util.HashMap;
import java.util.HashSet;


public class StudentServiceImp implements StudentService {
    private final StudentDaoImp studentDaoImp;

    public StudentServiceImp(StudentDaoImp studentDaoImp) {
        this.studentDaoImp = studentDaoImp;

    }

    @Override
    public void addNewStudent(Student student,String name) {
      studentDaoImp.addNewStudent(student,name);
    }

    @Override
    public void updateStudent(Long id, Student newOne) {
    studentDaoImp.updateStudent(id,newOne);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentDaoImp.findStudentByName(name);
    }

    @Override
    public HashMap<Long, Student> getAllStudentsByGroupName(String name) {
        return studentDaoImp.getAllStudentsByGroupName(name);
    }

    @Override
    public HashSet<Lesson> getAllStudentsLesson(Long id) {
        return studentDaoImp.getAllStudentsLesson(id);
    }

    @Override
    public void deleteStudent(String email) {
      studentDaoImp.deleteStudent(email);
    }

    @Override
    public Student varify(String email, String password) {
        return studentDaoImp.varify(email, password);
    }

    @Override
    public void getProfile(Student student) {
        System.out.println("ID - " + student.getId() + "\nNAME - " + student.getName() + "\nSURNAME - " + student.getSurname()
                            + "\nAGE - " + student.getAge() + "\nEMAIL - " + student.getEmail() + "\nPASSWORD - " + student.getPassword());
    }

    @Override
    public void getGroup(Student student) {
        studentDaoImp.getGroup(student);
    }

    public boolean checkExistEorP (String email ,String password){
      return   studentDaoImp.checkExistEorP(email,password);
    }
}
