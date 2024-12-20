package dao.imp;
import Models.Group;
import dao.GroupDao;
import database.DataBase;
import database.GenerateId;
import java.util.HashMap;
import java.util.Map;

public class GroupDaoImp implements GroupDao {

    @Override
    public void addGroup(Group newGroup) {
        Long copy = GenerateId.generateIdG();
        newGroup.setId(copy);
        DataBase.groups.put(copy,newGroup);
        System.out.println("SUCCESSFULLY ADDED");
    }

    @Override
    public Group getGroupByName(String name) {
        for(Map.Entry<Long,Group> entry : DataBase.groups.entrySet()){
            if(entry.getValue().getName().equals(name)){
                entry.getValue().setId(entry.getKey());
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void updateGroupName(String name,Long id) {
     DataBase.groups.get(id).setName(name);
        System.out.println("SUCCESSFULLY UPDATED");
    }

    @Override
    public HashMap<Long, Group> getAllGroup() {
        return DataBase.groups;
    }



    @Override
    public void deleteGroup(Long id) {
              DataBase.groups.remove(id);
        System.out.println("SUCCESSFULLY DELETED");

          }
}
