package eCommerce.core.concretes;

import eCommerce.core.abstracts.jGoogleService;
import eCommerce.entities.concretes.User;
import eCommerce.jGoogle.jGoogleManager;

public class jGoogleManagerAdapter implements jGoogleService {
    jGoogleManager jGoogleManager= new jGoogleManager();
    @Override
    public void logIn(User user) {
        jGoogleManager.logIn(user.getFirstName());
    }

    @Override
    public void signUp(User user) {
        jGoogleManager.signUp(user.getFirstName());
    }
}
