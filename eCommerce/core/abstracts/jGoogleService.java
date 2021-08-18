package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface jGoogleService {
    void logIn(User user);
    void signUp(User user);
}
