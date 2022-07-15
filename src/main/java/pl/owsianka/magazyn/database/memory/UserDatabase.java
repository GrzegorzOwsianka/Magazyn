package pl.owsianka.magazyn.database.memory;

import org.springframework.stereotype.Component;
import pl.owsianka.magazyn.database.IUserDAO;
import pl.owsianka.magazyn.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDatabase implements IUserDAO {
    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        users.add(new User(1,"admin","admin"));
        users.add(new User(2,"grzegorz","grzegorz"));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users){
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean isLoginExist(String login) {
        return getUserByLogin(login).isPresent();
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
