package eCommerce.core.concretes;

import eCommerce.core.abstracts.VerifiedService;
import eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class MailVerifiedService implements VerifiedService {
    List<String> verifiedEmails = new ArrayList<String>();

    @Override
    public void sendVerification(User user) {
        System.out.println(user.geteMail() + " adresine doğrulama linki gönderildi");
    }

    @Override
    public void verify(User user) {
        verifiedEmails.add(user.geteMail());

    }

    @Override
    public boolean checkVerified(User user) {
        if (verifiedEmails.contains(user.geteMail())) {
            return true;
        } else {
            System.out.println(user.geteMail() + " adresli email doğrulanmamış");
            return false;
        }

    }
}
