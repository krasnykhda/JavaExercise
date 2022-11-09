package innerClasses;

public class UserLocalClass {
    private final String login;
    private final String password;


    public UserLocalClass(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void crateQuery() {
        class Query {
            void printToLog() {
                System.out.println(login + " " + password);
            }
        }
        Query query = new Query();
        query.printToLog();
    }

    public static void main(String[] args) {
        UserInnerClass user = new UserInnerClass("dankras", "pwdpwdpwd");
        user.crateQuery();

    }
}
