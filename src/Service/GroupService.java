package Service;

import Models.Group;
import Models.Student;

import java.util.ArrayList;
import java.util.HashMap;

public interface GroupService {

    void addGroup (Group newGroup);

    Group getGroupByName(String name);

    void updateGroupName (String name,Long id);

    HashMap<Long, Group> getAllGroup ();


    void deleteGroup (String name);
}
