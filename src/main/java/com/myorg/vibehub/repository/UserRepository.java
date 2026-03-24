package com.myorg.vibehub.repository;
import com.myorg.vibehub.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    //Dummy DB
    private Map<Long, User> users = new HashMap<>();

    private static Long currentID = 0L;

    //adding User
    // it is receiving User object(POJO) from service layer

    public User addUser(User user) {
         Long id = ++currentID;
        user.setId(id);

        users.put(id, user);

        return users.get(id);

    }

    //getting / Searching user by ID

    public User getUser(Long id) {

        return users.get(id);
    }

    public List<User> getAllUser() {

        return new LinkedList<>(users.values());

    }

    public User updateUser(User user) {

        if(user.getId()!= null){

            users.put(user.getId(), user);

        }

        return users.get(user.getId());

    }

    public void removeUser(Long id) {

        users.remove(id);
    }


}
