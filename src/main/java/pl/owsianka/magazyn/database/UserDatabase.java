package pl.owsianka.magazyn.database;

import org.springframework.stereotype.Component;
import pl.owsianka.magazyn.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDatabase {
    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        users.add(new User(1,"admin","admin"));
        users.add(new User(2,"grzegorz","grzegorz"));
    }

    public List<User> getUsers() {
        return users;
    }
}
