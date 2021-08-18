import eCommerce.business.abstracts.UserCheckService;
import eCommerce.business.concretes.UserCheckManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.concretes.MailVerifiedService;
import eCommerce.core.concretes.jGoogleManagerAdapter;
import eCommerce.dataAccess.concretes.HibernateUserDao;
import eCommerce.entities.concretes.User;



public class Main {

    public static void main(String[] args) {
        UserManager userManager= new UserManager(new UserCheckManager(),new HibernateUserDao(),new jGoogleManagerAdapter(), new MailVerifiedService());
        User user1= new User(1,"Berk","Uyanık","info@berkuyanik.com","123124");
        User user2= new User(2,"Engin","Demiroğ","info@engindemirog.com","1235125");
        userManager.signUp(user1);
        userManager.signIn(user2);
        userManager.signInWithGoogle(user1);
        userManager.signUpWithGoogle(user2);


    }
}
