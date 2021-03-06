import model.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        String exit = "open";
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        System.out.println("Menu: ");
        System.out.println("1. Add ");
        System.out.println("2. Show ");
        System.out.println("3. Exit ");
        System.out.println("4. Unique ");
        System.out.println("5. Save ");
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
                    case "Unique":
                        Collections.sort(list);
                        List<String> unique = new ArrayList<>();
                        for (Person person : list) {
                            unique.add(person.getSecondName());
                        }
                        System.out.println(unique.stream().distinct().collect(Collectors.toList()));
                        break;
                    case "Save":
                        PrintWriter pw = null;
                        try {
                            pw = new PrintWriter(new FileOutputStream("storage"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        for (Person person : list) {
                            pw.println(person);
                        }
                        pw.close();
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