package architecture.tp_restcontroller.Service;

import architecture.tp_restcontroller.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;
    public UserService() {
        userList = new ArrayList<>();
        User user1=new User(1,"Mohammed","mhd@mail.com");
        User user2=new User(2,"Moad","moad@mail.com");
        User user3=new User(3,"Sana","sana@mail.com");
        User user4=new User(4,"Ahlam","ahlam@mail.com");
        userList.addAll(Arrays.asList(user1,user2,user3,user4));
    }
    public User getUser(Integer id){
        for(User usr:userList)
            if(id==usr.getId()) {
                return usr;
            }
        return null;
    }

    public void suppUser(Integer id){
        for(User usr:userList)
            if(id==usr.getId()) {
                userList.remove(usr);
            }
    }
    public List<User> getUsers(){
        return userList;
    }
    public String updateUser(int id,User user){
        int i=0;
        for(User usr:userList) {
            if (usr.getId() == id) {
                userList.set(i, user);
                return String.format("l'utilisateur %s est bien modifié !", id);
            } else
                i++;
        }
        return String.format("lutilisateur %s n'existe pas !",id);
    }
    public String addUser(User user){
        userList.add(user);
        return String.format("lutilisateur %s est bien ajouté !",user.getId());
    }
}

