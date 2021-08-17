package exams.utils;

import java.util.Scanner;

public class utils {
    public static String getInpString(Scanner sc, String inputMessage){
        if (!inputMessage.isEmpty())
            System.out.println(inputMessage);
//        else
//            System.out.println("empty");

        return sc.nextLine();
    }

    public static int getInpInt(Scanner sc, String inputMessage){
        if (!inputMessage.isEmpty())
            System.out.println(inputMessage);
//        else
//            System.out.println("empty");

        return Integer.parseInt(sc.nextLine());
    }


}
