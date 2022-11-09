public class UserInnerClass {
    private String login;
    private String password;

    private class Query {
        void printToLog() {
            System.out.println(login + " " + password);
        }
    }

    public UserInnerClass(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Query crateQuery() {
        return new Query();
    }

    public static void main(String[] args) {
        UserInnerClass user = new UserInnerClass("dankras", "pwdpwdpwd");
        Query query= user.crateQuery();
        query.printToLog();
        query=user.new Query();
        query.printToLog();

    }
}
