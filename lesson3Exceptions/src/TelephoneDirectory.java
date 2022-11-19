import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private final Map<String, List<String>> personsPhoneNumber;

    public TelephoneDirectory() {
        personsPhoneNumber = new HashMap<>();
    }

    public void addPersonNumber(String personName, String phoneNumber) {
        if (personsPhoneNumber.get(personName) == null) {
            personsPhoneNumber.put(personName, new ArrayList<>());
        }
        personsPhoneNumber.get(personName).add(phoneNumber);
    }

    public List<String> getPersonNumber(String personName) {
        return personsPhoneNumber.get(personName);
    }

    public static void main(String[] args) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.addPersonNumber("Вася", "123123");
        telephoneDirectory.addPersonNumber("Петя", "123123423");
        telephoneDirectory.addPersonNumber("Петя", "123321");
        System.out.println(telephoneDirectory.getPersonNumber("Петя"));
    }
}
