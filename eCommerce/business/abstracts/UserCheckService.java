package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserCheckService {
    boolean checkPassword(User user);
    boolean checkFirstName(User user);
    boolean checkLastName(User user);
    boolean checkEmail(User user);
    boolean checkUniqueEmail(User user);
    boolean isValid(User user);

}
