import java.text.NumberFormat;
import java.util.Locale;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Base salary must be greater than or equal to 0.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    @Override
    public double getPaymentAmount() {
        return baseSalary + super.getPaymentAmount();
    }

    public String formatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return formatter.format(value);
    }

    @Override
    public String toString() {
        return "base-salaried " + super.toString()
                + "; base salary: " + formatter(baseSalary);
    }
}