import java.text.NumberFormat;
import java.util.Locale;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    //Getter
    public double getGrossSales() {
        return grossSales;
    }

    //Setter
    public void setGrossSales(double grossSales) {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        } else {
            System.out.println("Gross sales must be greater than or equal to 0.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    //Getter
    public double getCommissionRate() {
        return commissionRate;
    }

    //Setter
    public void setCommissionRate(double commissionRate) {
        if (commissionRate > 0 && commissionRate < 1) {
            this.commissionRate = commissionRate;
        } else {
            System.out.println("Commission rate must be greater than 0 and less than 1.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    @Override
    public double getPaymentAmount() {
        return grossSales * commissionRate;
    }

    public String formatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return formatter.format(value);
    }

    @Override
    public String toString() {
        return "commission employee: " + super.toString() +
                "\ngrossSales: " + formatter(grossSales) +
                "; commissionRate: " + commissionRate;
    }
}
