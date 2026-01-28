package tax.management.system;

import java.util.Scanner;

public class Main {
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

        Taxable employee = new Employee(id, name, salary);
        System.out.println(employee.display());

        System.out.println("\nEnter Product Details");
        System.out.print("Enter Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Taxable product = new Product(pid, price, quantity);
        System.out.println(product.display());
    }
}
