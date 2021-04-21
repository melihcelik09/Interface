import java.text.NumberFormat;
import java.util.Locale;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        setWeeklySalary(weeklySalary);
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary >= 0) {
            this.weeklySalary = weeklySalary;
        } else {
            System.out.println("Weekly Salary must be equal to or greater than zero.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    public String formatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return formatter.format(value);
    }

    @Override
    public String toString() {
        return "salaried employee: " + super.toString() +
                "\nweekly salary: " + formatter(weeklySalary);
    }
}