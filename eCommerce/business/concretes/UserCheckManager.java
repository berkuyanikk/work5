package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserCheckService;
import eCommerce.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCheckManager implements UserCheckService {
    List<String> eMailList = new ArrayList<String>();
    @Override
    public boolean checkPassword(User user) {
        if (user.getPassword().isEmpty()){
            System.out.println("Parola boş bırakılamaz");
            return false;
        }
        else
        {
            if (user.getPassword().length()< 6){
                System.out.println("Parola en az altı karakter olmalıdır.");
                return false;
            }
            else{
                return true;
            }
        }
        }


    @Override
    public boolean checkFirstName(User user) {
        if (user.getFirstName().isEmpty()) {
            System.out.println("İsim boş bırakılamaz");
            return false;
        }
        else {
            if (user.getFirstName().length()< 2){
                System.out.println("İsim en az iki karakterden oluşturulmalıdır.");
                return false;
            }
            else{return true;}
        }
    }

    @Override
    public boolean checkLastName(User user) {
        if (user.getLastName().isEmpty()) {
            System.out.println("Soyisim boş bırakılamaz");
            return false;
        }
        else {
            if (user.getLastName().length()< 2){
                System.out.println("Soyisim en az iki karakterden oluşturulmalıdır.");
                return false;
            }
            else{return true;}
        }
    }

    @Override
    public boolean checkEmail(User user) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        if(user.geteMail().isEmpty()) {
            System.out.println("Email alanı boþ bırakılamaz.");
            return false;
        }else {
            Matcher matcher = pattern.matcher(user.geteMail());
            if(matcher.matches()) {
                return true;
            }else {
                System.out.println("yanlış email format kullanımı!");
                return false;
            }
        }
    }

    @Override
    public boolean checkUniqueEmail(User user) {
        if (eMailList.contains(user.geteMail())){
            System.out.println("Bu e-mail kullanılmaktadır.");
            return false;
        }
        else {
            eMailList.add(user.geteMail());
            return true;
        }
    }

    @Override
    public boolean isValid(User user) {
        if (checkFirstName(user) && checkLastName(user) && checkPassword(user) && checkUniqueEmail(user)
                && checkEmail(user) == true)
        {
            return true;
        }
        else {
            return false;
        }

    }
}
