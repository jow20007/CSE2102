package com.example.demo;
 
import java.util.regex.Pattern;

public class EmailChecker {
    String regexString = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{2,253}\\.[a-zA-Z]{2,7}$"; // copied and modified -> https://www.geeksforgeeks.org/check-if-email-address-valid-or-not-in-python/
    Pattern p = Pattern.compile(regexString);
    
    public boolean validEmail(String e) {
        // email should be: 1-64 character user @ 3-253 character domain . 2-7 character extension
        return p.matcher(e).matches();
    }
}