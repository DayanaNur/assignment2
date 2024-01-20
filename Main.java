import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Employee("John", "Lennon", "Manager", 50000.00));
        people.add(new Student("Paul", "McCartney", 3.5));

        while (true) {
            System.out.println("Select a class (Person, Employee, Student) or enter 'exit' to complete:");
            String choice = scanner.nextLine();

            if ("exit".equalsIgnoreCase(choice)) {
                break;
            }

            switch (choice.toLowerCase()) {
                case "person":
                    addPerson(scanner, people);
                    break;
                case "employee":
                    addEmployee(scanner, people);
                    break;
                case "student":
                    addStudent(scanner, people);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }

        Collections.sort(people);
        printData(people);
    }

    public static void addPerson(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        people.add(new Person(name, surname));
        System.out.println("Person added.");
    }

    public static void addEmployee(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        System.out.println("Person position:");
        String position = scanner.nextLine();

        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        people.add(new Employee(name, surname, position, salary));
        System.out.println("Employee added.");
    }

    public static void addStudent(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter your GPA:");
        double gpa;
        while (true) {
            try {
                gpa = Double.parseDouble(scanner.nextLine().replace(',', '.'));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        people.add(new Student(name, surname, gpa));
        System.out.println("Student added.");
    }

    public static void printData(Iterable<Person> people) {
        for (Person person : people) {
            System.out.println(
                    person.getPosition() + ": " + person + " earns: " + person.getPaymentAmount() + " tenge");
        }
    }
}
