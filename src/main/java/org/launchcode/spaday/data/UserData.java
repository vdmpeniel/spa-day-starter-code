package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {
   private static final Map<Integer, User> userData = new HashMap<>();

   public void add(User user){
       userData.put(user.getId(), user);
   }

   public User getById(int id){
       return userData.get(id);
   }

   public List<User> getAll(){
       return new ArrayList<>(userData.values());
   }

}
