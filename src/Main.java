import Models.Admin;
import Models.Group;
import Models.Lesson;
import Models.Student;
import Service.imp.GroupServiceImp;
import Service.imp.LessonServiceImp;
import Service.imp.StudentServiceImp;
import config.ValidOrNot;
import dao.imp.GroupDaoImp;
import dao.imp.LessonDaoImp;
import dao.imp.StudentDaoImp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    static Scanner scan2 = new Scanner(System.in);
  static  Scanner scan = new Scanner(System.in);
  static  GroupDaoImp groupDaoImp = new GroupDaoImp();
  static  GroupServiceImp groups = new GroupServiceImp(groupDaoImp);

  static  LessonDaoImp lessonDao = new LessonDaoImp();
  static LessonServiceImp lesson = new LessonServiceImp(lessonDao,groupDaoImp);

  static  StudentDaoImp studentDaoImp = new StudentDaoImp();
  static StudentServiceImp student = new StudentServiceImp(studentDaoImp);

    public static void main(String[] args) {

        Admin admin = new Admin("Admin123@gmail.com","Admin!345");
        admin.setEmail("Admin123@gmail.com");
        admin.setPassword("Admin!345");


        boolean isTrue = true;

       while(isTrue){
           boolean adminPannel = false;

           System.out.print("\n WRITE EMAIL ");
           String email = scan.nextLine();
           System.out.print("\n WRITE PASSWORD ");
           String password = scan.nextLine();

           if(email.equals(admin.getEmail()) && password.equals(admin.getPassword())){
              adminPannel = true;
           }else {
               Student user = student.varify(email,password);
               if(user != null){
                   studentPannel(user);
               }else{
                   System.out.println("\nLOGIN FAILD");
               }
           }

          while(adminPannel){
              int choice = 0;
              currentTime();
              System.out.println("""
                      \n
                      1 > ADD NEW GROUP
                      2 > GET GROUP BY NAME
                      3 > UPDATE GROUP NAME
                      4 > GET ALL GROUPS
                      5 > ADD NEW STUDENT TO GROUP
                      6 > UPDATE STUDENT
                      7 > FIND STUDENT BY FIRST NAME
                      8 > GET ALL STUDENTS BY GROUP NAME
                      9 > GET ALL STUDENT'S LESSON
                      10 > DELETE STUDENT BY EMAIL
                      11 > ADD NEW LESSON TO GROUP
                      12 > GET LESSON BY NAME
                      13 > GET ALL LESSON BY GROUP NAME
                      14 > DELETE LESSON BY ID
                      15 > DELETE GROUP BY NAME
                      16 > EXIT
                      """);



              try{
                   choice = new Scanner(System.in).nextInt();
              }catch (InputMismatchException e){
                  System.out.println("ONLY NUMBERS");
              }

              switch (choice){
                  case 1 : {
                      HashMap<Long,Student> students = new HashMap<>();
                      HashMap<Long, Lesson> lessons = new HashMap<>();
                      Long id = 0L;
                      System.out.println("WRITE NEW GROUP NAME");
                      String name = scan.nextLine();
                      System.out.println("WRITE DESCRIPTION");
                      String description = scan.nextLine();
                      Group newGroup = new Group(id,description,name,students,lessons);
                      groups.addGroup(newGroup);
                      break;
                  }
                  case 2 : {
                      System.out.println("WRITE GROUP NAME");
                      String name = scan.nextLine();
                      System.out.println( groups.getGroupByName(name) == null ? "GROUP WITH THIS NAME NOT FOUND":groups.getGroupByName(name));
                      break;
                  }
                  case 3 : {

                      System.out.println("WRITE ID");
                          try{
                              Long id = new Scanner(System.in).nextLong();
                              System.out.println("WRITE NEW NAME FOR GROUP");
                              String name = scan.nextLine();
                              groups.updateGroupName(name,id);
                          } catch (InputMismatchException e) {
                              System.out.println("ONLY NUMBERS");
                          }

                      break;
                  }
                  case 4 : {
                      System.out.println(groups.getAllGroup() == null ? "": groups.getAllGroup());
                      break;
                  }
                  case 5 : {
                      System.out.println("WRITE A NAME OF A GROUP IN WHICH YOU WANT TO ADD A STUDENT");
                      String groupName = scan.nextLine();
                          Student stud = studentBlank();
                          if(stud != null){
                              student.addNewStudent(stud,groupName);
                          }else{
                              System.out.println("SOMETHING WENT WRONG");
                          }
                          break;
                  }
                  case 6 : {
                            try{
                                System.out.println("WRITE STUDENT ID");
                                Long id = new Scanner(System.in).nextLong();
                                Student stud = studentBlank();
                                if(stud != null){
                                    student.updateStudent(id,stud);
                                }

                            }catch (InputMismatchException e){
                                System.out.println("ONLY NUMBERS");
                            }
                            break;
                  }
                  case 7 : {
                      System.out.println("WRITE STUDENT NAME");
                      String studName = scan.nextLine();
                      System.out.println(student.findStudentByName(studName) == null ? "STUDENT WITH THIS NAME NOT FOUND"
                                         : student.findStudentByName(studName));

                      break;
                  }
                  case 8 : {
                      System.out.println("WRITE GROUP NAME");
                      String groupName = scan.nextLine();
                      System.out.println(student.getAllStudentsByGroupName(groupName) == null ? "GROUP WITH THIS NAME NOT FOUND"
                                         : student.getAllStudentsByGroupName(groupName));
                      break;
                  }
                  case 9 : {
                      try{
                          System.out.println("WRITE STUDENT ID");
                          Long id = new Scanner(System.in).nextLong();
                          System.out.println(student.getAllStudentsLesson(id) == null ? "STUDENT WITH THIS ID NOT FOUND":student.getAllStudentsLesson(id) );
                      }catch (InputMismatchException e){
                          System.out.println("ONLY NUMBERS");
                      }
                      break;
                  }
                  case 10 : {
                      System.out.println("WRITE STUDENT EMAIL");
                      String emailS = scan.nextLine();
                      student.deleteStudent(emailS);
                      break;

                  }
                  case 11 : {
                      Long id = 0L;
                      System.out.println("WRITE GROUP NAME");
                      String groupN = scan.nextLine();
                      System.out.println("WRITE LESSON NAME");
                      String lessonName = scan.nextLine();
                      Lesson lesson1 = new Lesson(id,lessonName, LocalDate.now());
                      lesson.addLesson(lesson1,groupN);
                      break;
                  }
                  case 12 : {
                      System.out.println("WRITE LESSON NAME");
                      String lessonName = scan.nextLine();
                      System.out.println( lesson.getLessonByName(lessonName) == null ? "LESSON WITH THIS NAME NOT FOUND"
                                         : lesson.getLessonByName(lessonName) );
                      break;
                  }
                  case 13 : {
                      System.out.println("WRITE GROUP NAME");
                      String groupN = scan.nextLine();
                      System.out.println( lesson.getAllLessonsByGroupName(groupN) == null ? "GROUP WITH THIS NAME NOT FOUND" :
                                          lesson.getAllLessonsByGroupName(groupN));
                      break;
                  }
                  case 14 : {

                      System.out.println("WRITE LESSON ID");
                      try{
                         Long  id = new Scanner(System.in).nextLong();
                          lesson.deletaLesson(id);
                      }catch (InputMismatchException e){
                          System.out.println("ONLY NUMBERS");
                      }
                      break;
                  }
                  case 15 : {
                      System.out.println("WRITE GROUP NAME");
                      String groupN = scan.nextLine();
                      groups.deleteGroup(groupN);
                      break;
                  }
                  case 16 : {
                      adminPannel = false;
                      break;
                  }

                  default:{
                      System.out.println("INVALID COMMAND");
                  }

              }
          }

       }

    }


    public static void studentPannel (Student user){
        boolean isTrue = true;
        int choice = 0;
        currentTime();
        while(isTrue){
            System.out.println("""
                    \n
                    1 > GET PROFIL
                    2 > GET LESSON
                    3 > GET GROUP
                    4 > BACK
                    \n
                    """);
            try{
               choice = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.println("ONLY NUMBERS");
            }
            switch (choice){
                case 1 : {
                    student.getProfile(user);
                    break;
                }
                case 2 : {
                     try{
                         System.out.println( student.getAllStudentsLesson(user.getId()));
                     }catch (InputMismatchException e){
                         System.out.println("ONLY NUMBERS");
                     }
                     break;
                }
                case 3 : {
                    student.getGroup(user);
                    break;
                }
                case 4 : {
                    isTrue = false;
                    System.out.println("GOODBAY\n");
                    break;
                }
                default:{
                    System.out.println("INVALID COMMAND");
                }
            }
        }
    }

  public static boolean check ( String email , String password){

     if(ValidOrNot.validEmail(email) && ValidOrNot.validPassword(password)){
         System.out.println("✅");
         return true;
     }
       return false;
  }

  public static Student studentBlank(){
        boolean turnOff = true;
      HashSet<Lesson> lessons = new HashSet<>();
      System.out.println("WRITE STUDENT NAME");
      String name = scan2.nextLine();
      System.out.println("WRITE STUDENT SURNAME");
      String surname = scan2.nextLine();
      System.out.println("WRITE STUDENT AGE");
      int age = 0;
      do{
          try{
              age = new Scanner(System.in).nextInt();
              turnOff = false;
          }catch (InputMismatchException e){
              System.out.println("ONLY NUMBERS");
          }
      }while(turnOff);

      System.out.println("WRITE EMAIL");
      String emailAdd = scan2.nextLine();
      System.out.println("WRITE PASSWORD");
      String passwordAdd = scan2.nextLine();
      boolean bool = false ;
      Long id = 0L;
      if(check(emailAdd,passwordAdd)) {
           bool = student.checkExistEorP(emailAdd,passwordAdd);
      }

      if(bool){
          return new Student(id,name,surname,
                  age,emailAdd,passwordAdd,lessons);
         }
      return null;

  }

  public static void currentTime(){
        LocalTime time = LocalTime.now();
        int copy =  time.getHour();

        if(copy < 11 && copy > 5){
            System.out.println("\nGOOD MORNING >> " + time.getHour() + ":" +time.getMinute());
        }else if(copy >= 11 && copy < 18){
            System.out.println("\nGOOD AFTERNOON >> " + time.getHour() +":"+ time.getMinute());
        }else{
            System.out.println("\nGOOD EVENING >> " + time.getHour() +":"+ time.getMinute());
        }
  }


}