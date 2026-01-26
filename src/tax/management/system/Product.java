package tax.management.system;

final class Product implements Taxable {
    private final int pid;
    private final double price;
    private final int quantity;

    private double salesTaxAmount;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;

        calcTax();
    }

    @Override
    public void calcTax() {
        salesTaxAmount = price * Taxable.salesTax;
    }

    @Override
    public String display() {
        return String.format("Product ID: %d | Price: %.2f | Quantity: %d | Sales Tax(per unit): %.2f",
                pid, price, quantity, salesTaxAmount);
    }
}