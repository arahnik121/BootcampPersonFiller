import model.Person;

public class Main1 {
    public static void main(String[] args) {
        Person person = new Person("", "");
        if (args.length <= 1) {
            System.out.println("Wrong number of arguments");
        } else {
            person.setFirstName(args[0]);
            person.setSecondName(args[1]);
            System.out.println(person.getFirstName() + " " + person.getSecondName());
        }
    }
}

