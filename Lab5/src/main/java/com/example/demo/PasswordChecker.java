package com.example.demo;

public class PasswordChecker {
    public boolean validPassword(String pw) {
        // password should be:
        //  - between 8 and 100 characters in length
        //  - have at least one capital letter, lowercase letter, and one number
        //  - have at least one special character (!, ", #, $, %, &, ', (, ), *, +, ,, -)
        return pw.length() >= 8 && pw.length() <= 100 && hasUpperLowerNumberSpecial(pw);
    }

    public boolean hasUpperLowerNumberSpecial(String pw) {
        // check password for at least one capital letter, lowercase letter, one number
        // and one special character (!, ", #, $, %, &, ', (, ), *, +, ,, -)
        boolean hasUpper = false, hasLower = false, hasNumber = false, hasSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            int cc = (int)pw.charAt(i);
            if (cc >= 33 && cc <= 45) { // !, ", #, $, %, &, ', (, ), *, +, ,, -
                hasSpecial = true;
            } else if (cc >= 48 && cc <= 57) { // 0-9
                hasNumber = true; 
            } else if (cc >= 65 && cc <= 90) { // A-Z
                hasUpper = true;
            } else if (cc >= 97 && cc <= 122) { // a-z
                hasLower = true;
            }
        }
        return hasUpper && hasLower && hasNumber && hasSpecial;
    }
}