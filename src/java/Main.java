import model.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person(scanner.next(), scanner.next());
        System.out.println(person.getFirstName() + " " + person.getSecondName());
    }
}
