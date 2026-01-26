package tax.management.system;

final class Employee implements Taxable {
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