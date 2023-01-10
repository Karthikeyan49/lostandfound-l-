package packages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class user {
    public String email,password,mobile_number,address,name;
    public boolean password_validate(String password){
        String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
    public boolean numbervalidate(String num){
    String reg="^\\d{10}$";
     Pattern p= Pattern.compile(reg);
     Matcher m=p.matcher(num);
     return m.matches();
    }
}

