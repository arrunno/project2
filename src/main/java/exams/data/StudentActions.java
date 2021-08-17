package exams.data;

public enum StudentActions {

    REGISTER(1, "Registruotis"),
    LOGIN(2,"Prisijungti"),
    CHOOSE_EGZAM(3, "Pasirinkti egzaminą"),
    SEE_RESULTS(4, "Peržiūrėti rezultatus"),
    QUIT(5, "Išeiti");

    private int num;
    private String action;

    StudentActions(int pNum, String pAction){
        num = pNum;
        action = pAction;
    }

    public int getNum() {
        return num;
    }

    public String getAction() {
        return action;
    }
}
