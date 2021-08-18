package eCommerce.dataAccess.concretes;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    List<User> users= new ArrayList<User>();

    @Override
    public void add(User users) {
        System.out.println("Kullanıcı hibernate ile eklendi. "+users.getFirstName()+" "+ users.getLastName());
    }

    @Override
    public void delete(User users) {

    }

    @Override
    public void update(User users) {

    }

    @Override
    public boolean mailCheck(String email) {
        for (User user: users){
            if (user.geteMail()== email){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean pwCheck(String password) {
        for (User user: users){
            if (user.getPassword()==password){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
