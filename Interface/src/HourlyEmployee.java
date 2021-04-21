import java.text.NumberFormat;
import java.util.Locale;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        setWage(wage);
        setHours(hours);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        if (wage >= 0) {
            this.wage = wage;
        } else {
            System.out.println("Wage must be equal to or greater than zero.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }

    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours >= 0 && hours < 168) {
            this.hours = hours;
        } else {
            System.out.println("Hours must be equal to or greater than 0 and less than 168.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    @Override
    public double getPaymentAmount() {
        if (hours <= 40) {
            return wage * hours;
        } else if (hours > 40) {
            return 40 * wage + (hours - 40) * wage * 1.5;
        }
        return 0;
    }

    public String formatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return formatter.format(value);
    }

    @Override
    public String toString() {
        return "hourly employee: " + super.toString() +
                "\nhourly wage: " + formatter(wage) +
                "; hours worked: " + hours;
    }
}

