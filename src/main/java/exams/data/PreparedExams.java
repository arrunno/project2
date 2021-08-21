package exams.data;

import java.util.HashMap;
import java.util.Map;

public class PreparedExams {

    private static String[] oopBasics_123 = new String[] {
            "1. Kas yra konstruktorius? \n" +
                    "a. kintamasis \n" +
                    "b. pradinis klases metodas \n" +
                    "c. operatorius",
            "2. Koks interfeisas naudojamas objektams serializuoti? \n" +
                    "a. Creatable \n" +
                    "b. Writable \n" +
                    "c. Serializable \n" +
                    "d. Copyable",
            "3. Koks zodis naudojamas kuriant Klases objektą? \n" +
                    "a. new \n" +
                    "b. parent \n" +
                    "c. self \n" +
                    "d. create",
            "4. Koki metoda naudojame prideti nauja elementa prie Map kolekcijos? \n" +
                    "a. add() \n" +
                    "b. put() \n" +
                    "c. push() \n" +
                    "d. bind() ",
            "5. Pagal Java konvencija, Generics k reiskia: \n" +
                    "a. tipa \n" +
                    "b. elementa \n" +
                    "c. rakta \n" +
                    "d. konstanta",
            "6. Koks metodas naudojamas gauti dabartiniam laikui? \n" +
                    "a. before() \n" +
                    "b. after() \n" +
                    "c. soon() \n" +
                    "d. now()"
    };

    private static String[] geography_124 = new String[] {
            "1. Koks yra didziausias Lietuvos ezeras? \n" +
                    "a. Dysnai \n" +
                    "b. Druksiai \n" +
                    "c. Asveja \n" +
                    "d. Sartai",
            "2. Kokia Ilgiausia pasaulio upe? \n" +
                    "a. Kongas \n" +
                    "b. Amazone \n" +
                    "c. Nilas \n" +
                    "d. Jenisejus",
            "3. Kur yra Andu kalnynas? \n" +
                    "a. Afrikoje \n" +
                    "b. Europoje \n" +
                    "c. Azijoje \n" +
                    "d. Pietu Amerikoje",
            "4. Kieno sostine yra Kolombas? \n" +
                    "a. Kolumbijos \n" +
                    "b. Venesuelos \n" +
                    "c. Angolos \n" +
                    "d. Sri Lankos"
    };

    private static Map<String, String[]> preparedExams = new HashMap<>(){{
       put("oopBasics_123", oopBasics_123);
       put("geography_124", geography_124);
    }};

    public static String[] getOopBasics_123() {
        return oopBasics_123;
    }

    public static String[] getGeography_124() {
        return geography_124;
    }

    public static Map<String, String[]> getPreparedExams() {
        return preparedExams;
    }
}
