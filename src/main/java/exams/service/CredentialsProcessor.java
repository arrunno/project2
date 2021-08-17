package exams.service;

import exams.data.IntructorsCredentialsData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CredentialsProcessor implements CredentialsService {

    @Override
    public boolean isEmailPresent(Map<String, String> credentials, String email) {
        return credentials.containsKey(email);
    }

//    public boolean checkAllEmails(){
//        return false;
//    }

    @Override
    public boolean isPasswordRight(Map<String, String> credentials,String email, String password) {
        boolean res = false;
        if(credentials.get(email).equals(password))
            res = true;
        return res;
    }
}
