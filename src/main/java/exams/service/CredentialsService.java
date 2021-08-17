package exams.service;

import java.util.Map;

public interface CredentialsService {
    public boolean isEmailPresent(Map<String, String> credentials, String email);
    boolean isPasswordRight(Map<String, String> credentials, String email, String password);
}
