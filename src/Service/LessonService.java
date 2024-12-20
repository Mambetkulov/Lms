package Service;

import Models.Lesson;

import java.util.HashMap;

public interface LessonService {

    void addLesson (Lesson lesson,String name);

    Lesson getLessonByName (String name);

    HashMap<Long,Lesson> getAllLessonsByGroupName (String name);

    void deletaLesson (Long id);

}
