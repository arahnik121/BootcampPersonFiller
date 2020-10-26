package model;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    @Override
    public int compareTo(Person o) {
        if (getSecondName() == null || o.getSecondName() == null) {
            return 0;
        }
        return getSecondName().compareTo(o.getSecondName());
    }
}
