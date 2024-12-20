package dao.imp;
import Models.Group;
import Models.Lesson;
import Models.Student;
import dao.StudentDao;
import database.DataBase;
import database.GenerateId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StudentDaoImp implements StudentDao {

    @Override
    public void addNewStudent(Student student,String name) {

        boolean isTrue = true;
        for(Map.Entry<Long, Group> entry : DataBase.groups.entrySet()){
            if(entry.getValue().getName().equals(name)){
                Long copy = GenerateId.generateIdS();
                student.setId(copy);
                isTrue = false;
                System.out.println("SUCCESSFULLY ADDED");
              entry.getValue().getStudents().put(copy,student);
              break;
            }
        }
        if(isTrue) System.out.println("GROUP WITH THIS NAME NOT FOUND");
    }

    @Override
    public void updateStudent(Long id, Student newOne) {
        boolean isTrue = true;
    for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
        for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
            if(student.getKey().equals(id)){
                isTrue = false;
                newOne.setId(student.getValue().getId());
                System.out.println("SUCCESSFULLY UPDATED");
                student.setValue(newOne);
                break;
            }
        }
    }
    if(isTrue) System.out.println("STUDENT WITH THIS ID NOT FOUND");
    }

    @Override
    public Student findStudentByName(String name) {
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
            for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
                if(student.getValue().getName().equals(name)){
                    return student.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public HashMap<Long, Student> getAllStudentsByGroupName(String name) {
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
            if(entry.getValue().getName().equals(name)){
                return entry.getValue().getStudents();
            }
        }
        return null;
    }

    @Override
    public HashSet<Lesson> getAllStudentsLesson(Long id) {
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()) {
            for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
                if(student.getValue().getId().equals(id)){
                    return student.getValue().getLessons();
                }
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(String email) {
        boolean isTrue = true;
     for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
         for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
             if(student.getValue().getEmail().equals(email)){
                 isTrue = false;
                 entry.getValue().getStudents().remove(student.getKey());
                 System.out.println("SUCCESSFULLY DELETED");
                 break;
             }
         }
     }
     if(isTrue) System.out.println("STUDENT WITH THIS EMAIL NOT FOUND");
    }

    @Override
    public Student varify(String email, String password) {
       for(Map.Entry<Long,Group> entry :  DataBase.groups.entrySet()){
           for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
               if(student.getValue().getEmail().equals(email) && student.getValue().getPassword().equals(password)){
                   return student.getValue();
               }
           }
       }
        return null;
    }

    public boolean checkExistEorP (String email ,String password){
        int count = 0;
        for(Map.Entry<Long , Group> entry : DataBase.groups.entrySet()){
            for(Map.Entry<Long,Student> student : entry.getValue().getStudents().entrySet()){
                if(student.getValue().getEmail().equals(email)&& student.getValue().getPassword().equals(password)){
                    System.out.println("EMAIL OR PASSWORD ALREADY EXIST");
                    count ++;
                }
            }
        }

        if(count > 0 ) {
            return false;
        }
        return true;
    }

    @Override
    public void getGroup(Student student) {
        for(Map.Entry<Long ,Group> entry : DataBase.groups.entrySet()){
            for (Map.Entry<Long,Student> st : entry.getValue().getStudents().entrySet()){
                if(st.getValue().equals(student)){
                    System.out.println("Group name - " + entry.getValue().getName() + "\nDescription - " +
                                       entry.getValue().getDescription());
                }
            }
        }
    }


}
