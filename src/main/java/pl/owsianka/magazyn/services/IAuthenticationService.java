package pl.owsianka.magazyn.services;

import pl.owsianka.magazyn.model.User;

public interface IAuthenticationService {
    void authenticate(User user);
    void register(User user);
    void logout();
}
