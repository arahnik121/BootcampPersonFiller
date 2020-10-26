import model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String exit = "open";
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        while (!exit.equals("exit")) {
            String firstName = scanner.next();
            if (firstName.equals("exit")) {
                exit = "exit";
            } else {
                String secondName = scanner.next();
                if (secondName.equals("exit")) {
                    exit = "exit";
                } else {
                    Person person = new Person(firstName, secondName);
                    list.add(person);
                }
            }
        }
        scanner.close();
        Collections.sort(list);
        for (Person person : list) {
            System.out.println(person.getFirstName() + " " + person.getSecondName());
        }
    }
}
