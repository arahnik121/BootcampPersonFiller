import model.Person;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        String exit = "open";
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        System.out.println("Menu: ");
        System.out.println("1. Add ");
        System.out.println("2. Show ");
        System.out.println("3. Exit ");
        while (!exit.equals("exit")) {
            String line = scanner.nextLine();
            args = line.split(" ");
            if (args.length == 3 || args.length == 1) {
                switch (args[0]) {
                    case "Add":
                        list.add(new Person(args[1], args[2]));
                        break;
                    case "Show":
                        Collections.sort(list);
                        for (Person person : list) {
                            System.out.println(person.getFirstName() + " " + person.getSecondName());
                        }
                        break;
                    case "Exit":
                        exit = "exit";
                        break;
                    default:
                        System.out.println("No action " + args[0] + " in menu");
                        break;
                }
            } else {
                System.out.println("Wrong number of arguments");
            }
        }
        scanner.close();
    }
}