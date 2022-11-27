import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private final Map<String, List<String>> personsPhoneNumber;

    public PhoneDirectory() {
        personsPhoneNumber = new HashMap<>();
    }

    public void addPersonNumber(String personName, String phoneNumber) {
        if (!personsPhoneNumber.containsKey(personName)) {
            personsPhoneNumber.put(personName, new ArrayList<>());
        }
        personsPhoneNumber.get(personName).add(phoneNumber);
    }

    public List<String> getPersonNumber(String personName) {
        return personsPhoneNumber.get(personName);
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.addPersonNumber("Вася", "123123");
        phoneDirectory.addPersonNumber("Петя", "123123423");
        phoneDirectory.addPersonNumber("Петя", "123321");
        System.out.println(phoneDirectory.getPersonNumber("Петя"));
    }
}
