package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserService {
    void signUp(User user);
    void signIn(User user);
    void signUpWithGoogle(User user);
    void signInWithGoogle(User user);
}
