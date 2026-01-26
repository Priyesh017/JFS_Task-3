import java.util.Scanner;

interface Taxable {
    double salesTax = 0.07;
    double incomeTax = 0.105;
    void calcTax();
    String display();
}

final class Employee implements Taxable{
    private final int empId;
    private final String name;
    private final double salary;

    private double incomeTaxAmount;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;

        calcTax();
    }

    @Override
    public void calcTax() {
        incomeTaxAmount = salary * Taxable.incomeTax;
    }

    @Override
    public String display() {
        return String.format("Employee ID: %d | Name: %s | Salary: %.2f | Income Tax: %.2f",
                empId, name, salary, incomeTaxAmount);
    }
}

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

public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Details");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(id, name, salary);
        System.out.println(employee.display());

        System.out.println("\nEnter Product Details");
        System.out.print("Enter Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(pid, price, quantity);
        System.out.println(product.display());
    }
}
