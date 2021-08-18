package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.abstracts.VerifiedService;
import eCommerce.core.abstracts.jGoogleService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
    private UserCheckManager userCheckManager;
    private UserDao userDao;
    private jGoogleService googleService;
    private VerifiedService verifiedService;

    public UserManager(UserCheckManager userCheckManager, UserDao userDao, jGoogleService googleService, VerifiedService verifiedService) {
        this.userCheckManager = userCheckManager;
        this.userDao = userDao;
        this.googleService = googleService;
        this.verifiedService = verifiedService;
    }

    @Override
    public void signUp(User user) {
        if (userCheckManager.isValid(user)){
            userDao.add(user);
            verifiedService.sendVerification(user);
        }

    }

    @Override
    public void signIn(User user) {
        verifiedService.verify(user);
        if (userDao.mailCheck(user.geteMail())&& userDao.pwCheck(user.getPassword())== true){
            System.out.println(user.getFirstName()+" Sisteme başarılı bir şekilde giriş yapıldı");
        }
        else{
            if (!verifiedService.checkVerified(user)){
                System.out.println(user.geteMail()+ " adresli email doğrulanmamış");
            }
            else {
                System.out.println("hatalı giriş sağlandı");
            }
        }

    }

    @Override
    public void signUpWithGoogle(User user) {
        googleService.signUp(user);

    }

    @Override
    public void signInWithGoogle(User user) {
        googleService.logIn(user);

    }
}
