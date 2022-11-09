package innerClasses;

public class UserStaticClass {
    private   String login;
    private String password;

    static class Query {
        void printToLog(String login,String password) {
            System.out.println(login + " " + password);
        }
    }
    public UserStaticClass(String login, String password) {
        this.login = login;
        this.password = password;
    }



    public static void main(String[] args) {
        UserStaticClass userStaticClass=new UserStaticClass("login","pwd");
        Query query=new Query();
        query.printToLog(userStaticClass.login,userStaticClass.password);

    }
}
