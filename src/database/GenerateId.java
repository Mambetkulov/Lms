package database;

public class GenerateId {

   static private Long groupId = 1L;
   static private Long studentId = 1L;
   static private Long lessonId = 1L;

    public static Long generateIdG (){
        return groupId ++;
    }

    public static Long generateIdS(){
        return studentId ++;
    }

    public static Long generateIdL(){
        return lessonId ++;
    }




}
