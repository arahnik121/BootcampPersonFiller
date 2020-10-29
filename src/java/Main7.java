import model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main7 {
    static List<Person> list = new ArrayList<>();
    static Scanner scanner;
    static Path path = Paths.get("storage");

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.fillMenu(new MenuItem("Add", Main7::add));
        menu.fillMenu(new MenuItem("Show", Main7::show));
        menu.fillMenu(new MenuItem("ShowUniqueSorted", Main7::showUniqueSorted));
        menu.fillMenu(new MenuItem("SaveFile", Main7::saveFile));
        menu.fillMenu(new MenuItem("ReadFile", Main7::readFile));
        menu.fillMenu(new MenuItem("ClearMemory", Main7::clearMemory));
        menu.fillMenu(new MenuItem("Exit", Main7::exit));

        menu.showMenu();
        while (true) {
            start(menu);
        }
    }

    private static void start(Menu menu) {
        String action = scanner.nextLine();
        for (int i = 0; i < menu.items.size(); i++) {
            if (menu.items.get(i).name.equals(action)) {
                try {
                    menu.items.get(i).getExec().exec(list);
                } catch (Exception e) {
                    System.out.println("Wrong action, try again ...");
                }
            }
        }
    }

    private static void add(List<Person> list) {
        String line = scanner.nextLine();
        String[] array = line.split(" ");
        list.add(new Person(array[0], array[1]));
    }

    private static void show(List<Person> list) {
        if (list.size() > 0) {
            for (Person person : list) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("The list is empty!");
        }
    }

    private static void showUniqueSorted(List<Person> list) {
        Collections.sort(list);
        List<String> unique = new ArrayList<>();
        for (Person person : list) {
            unique.add(person.getSecondName());
        }
        System.out.println(unique.stream().distinct().collect(Collectors.toList()));
    }

    private static void saveFile(List<Person> list) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("storage"));
            for (Person person : list) {
                pw.println(person);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(List<Person> list) {
        try {
            for (int i = 0; i < Files.readAllLines(path).size(); i++) {
                String line = Files.readAllLines(path).get(i);
                String[] array = line.split(" ");
                list.add(new Person(array[0], array[1]));
            }
            System.out.println(list);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private static void clearMemory(List<Person> list) {
        list.clear();
    }

    private static void exit(List<Person> list) {
        System.exit(0);
    }

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        public MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }


        public Exec getExec() {
            return exec;
        }
    }

    private static class Menu {
        private List<MenuItem> items;

        public Menu(Scanner scanner) {
            this.items = new ArrayList<>();
        }

        void fillMenu(MenuItem item) {
            items.add(item);
        }

        void showMenu() {
            for (MenuItem item : items) {
                System.out.println(item.name);
            }
        }
    }

}
