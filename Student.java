
public class Student extends Person {
    private double gpa;

    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public double getPaymentAmount() {
        return (gpa > 2.67) ? 36660.00 : 0.0;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", GPA: " + gpa;
    }

    @Override
    public int compareTo(Person other) {
        if (other instanceof Student) {
            return Double.compare(this.gpa, ((Student) other).gpa);
        }
        return super.compareTo(other);
    }
}
