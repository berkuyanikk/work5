package eCommerce.dataAccess.abstracts;

import eCommerce.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User users);
    void delete(User users);
    void update(User users);
    boolean mailCheck(String email);
    boolean pwCheck(String password);
    List<User> getAll();
}
