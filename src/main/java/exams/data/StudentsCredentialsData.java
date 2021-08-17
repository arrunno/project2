package exams.data;

import java.util.HashMap;
import java.util.Map;

public class StudentsCredentialsData {
    private static Map<String, String> credentials = new HashMap<String, String>(){{
        put("instruktorius.petras@pastas.com", "petraspwd");
        put("instruktorius.inga@pastas.lt", "ingapwd");
    }};

    public static Map<String, String> getCredentials() {
        return credentials;
    }
}
