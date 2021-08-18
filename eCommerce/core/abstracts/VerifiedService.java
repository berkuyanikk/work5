package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface VerifiedService {
    void sendVerification(User user);
    void verify(User user);
    boolean checkVerified(User user);

}
