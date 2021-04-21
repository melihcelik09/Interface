import java.text.NumberFormat;
import java.util.Locale;

public class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        setPartNumber(partNumber);
        setPartDescription(partDescription);
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0) {
            this.pricePerItem = pricePerItem;
        } else {
            System.out.println("Price must be bigger than zero");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be equal or bigger than zero.");
            System.out.println("Program is terminating...");
            System.exit(0);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public String formatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return formatter.format(value);
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "invoice:\n" +
                "partNumber: " + partNumber +
                " (" + partDescription + ")\n" +
                "quantity: " + quantity +
                "\npricePerItem: " + formatter(pricePerItem);
    }
}
