package Service.imp;
import Models.Group;
import Service.GroupService;
import dao.imp.GroupDaoImp;
import java.util.HashMap;
import java.util.Map;

public class GroupServiceImp implements GroupService {
    private final GroupDaoImp groupDaoImp;

    public GroupServiceImp(GroupDaoImp groupDaoImp) {
        this.groupDaoImp = groupDaoImp;
    }

    @Override
    public void addGroup(Group newGroup) {
        boolean turnOff = true;
      for(Map.Entry<Long,Group> entry : groupDaoImp.getAllGroup().entrySet()){
          if(entry.getValue().getName().equals(newGroup.getName())){
              turnOff = false;
              System.out.println("GROUP WITH NAME ALREADY EXIST");
          }
      }

      if(turnOff)groupDaoImp.addGroup(newGroup);
    }


    @Override
    public Group getGroupByName(String name) {
        return groupDaoImp.getGroupByName(name);
    }

    @Override
    public void updateGroupName(String name,Long id) {
        boolean turnOff = true;
     for(Map.Entry<Long , Group> entry : groupDaoImp.getAllGroup().entrySet()){
         if(entry.getKey().equals(id)){
             turnOff = false;
             groupDaoImp.updateGroupName(name,id);
         }
     }
     if(turnOff) System.out.println("GROUP WITH THIS ID NOT FOUND");

    }

    @Override
    public HashMap<Long, Group> getAllGroup() {
        return groupDaoImp.getAllGroup();
    }





    @Override
    public void deleteGroup(String name) {
        try {
            for (Map.Entry<Long, Group> entry : groupDaoImp.getAllGroup().entrySet()) {
                if (entry.getValue().getName().equals(name)) {
                    groupDaoImp.deleteGroup(entry.getKey());
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }
    }
}
