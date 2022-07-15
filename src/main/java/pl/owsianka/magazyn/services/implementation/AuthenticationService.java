package pl.owsianka.magazyn.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.owsianka.magazyn.database.IUserDAO;
import pl.owsianka.magazyn.exceptions.LoginAlreadyExistException;
import pl.owsianka.magazyn.model.User;
import pl.owsianka.magazyn.services.IAuthenticationService;
import pl.owsianka.magazyn.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    public void authenticate(User user) {
        Optional<User> userFromDB = this.userDAO.getUserByLogin(user.getLogin());
        if (userFromDB.isPresent() && userFromDB.get().getPassword().equals(user.getPassword())) {
            this.sessionObject.setLogged(true);
        }
    }

    public void register(User user) {
        if (this.userDAO.isLoginExist(user.getLogin())) {
            throw new LoginAlreadyExistException();
        }
        this.userDAO.addUser(user);
    }

    public void logout() {
        this.sessionObject.setLogged(false);
    }
}
