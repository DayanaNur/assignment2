
public class Employee extends Person {
    private String position;
    private double salary;

    public Employee(String name, String surname, String position, double salary) {
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public double getPaymentAmount() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }

    @Override
    public int compareTo(Person other) {
        if (other instanceof Employee) {
            return Double.compare(this.salary, ((Employee) other).salary);
        }
        return super.compareTo(other);
    }
}
