package Service.imp;
import Models.Group;
import Models.Lesson;
import Service.LessonService;
import dao.imp.GroupDaoImp;
import dao.imp.LessonDaoImp;
import java.util.HashMap;
import java.util.Map;
public class LessonServiceImp implements LessonService {
    private final GroupDaoImp group;
    private final LessonDaoImp lessonDaoImp;

    public LessonServiceImp(LessonDaoImp lessonDaoImp,GroupDaoImp group) {
        this.lessonDaoImp = lessonDaoImp;
        this.group = group;
    }

    @Override
    public void addLesson(Lesson lesson,String name) {
        boolean turnOff = true;
        for (Map.Entry<Long, Group> entry : group.getAllGroup().entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                turnOff = false;
                lessonDaoImp.addLesson(lesson,name);
            }

            if(turnOff){
                System.out.println("GROUP WITH THIS ID NOT FOUND");
            }
        }
    }

    @Override
    public Lesson getLessonByName(String name) {
        return lessonDaoImp.getLessonByName(name);
    }

    @Override
    public HashMap<Long, Lesson> getAllLessonsByGroupName(String name) {
        return lessonDaoImp.getAllLessonsByGroupName(name);
    }

    @Override
    public void deletaLesson(Long id) {
      lessonDaoImp.deletaLesson(id);
    }
}
