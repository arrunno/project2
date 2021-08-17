package exams.data;

import java.util.HashMap;
import java.util.Map;

public class IntructorsCredentialsData {
    private static Map<String, String> credentials = new HashMap<String, String>(){{
        put("inst.petras@pastas.com", "petraspwd");
        put("inst.inga@pastas.com", "ingapwd");
    }};


    public static Map<String, String> getCredentials() {
        return credentials;
    }

}
