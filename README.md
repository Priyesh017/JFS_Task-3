# JFS TASK 3: OOP PROGRAMMING
## EXECUTION & PROBLEM GUIDE

> **NOTE:** I have implemented Encapsulation (private fields with getter methods). Although this concept goes slightly beyond what has been covered in class so far, I used it to ensure better data security and standard coding practice.

---

## 🚀 HOW TO RUN THE SUBMISSION

### TASK A: LIBRARY MANAGEMENT SYSTEM

**STEP 1: COMPILE**  
Type the following command in your terminal/command prompt and hit Enter:
```bash
javac library/management/system/*.java
```

**STEP 2: RUN**  
Type the following command and hit Enter:

```bash
java library.management.system.Main
```

#### 📄 PROBLEM STATEMENT

Design a java program that uses OOP principles to model a `Book`. Create two classes: `Book` and `Library`.

* The **Book** class should have attributes such as `bookID`, `title`, `author`, and `isAvailable`.
* The **Library** class should include an array to store book objects. Provide methods to add books, remove books, search books (using ID), and display books.

Write a java program that demonstrates the use of these classes and methods by allowing the user to interact with the Library System.

---

### TASK B: TAX MANAGEMENT SYSTEM

**STEP 1: COMPILE**  
Type the following command and hit Enter:

```bash
javac tax/management/system/*.java
```

**STEP 2: RUN**  
Type the following command and hit Enter:

```bash
java tax.management.system.Main
```

#### 📄 PROBLEM STATEMENT

Create Interface `Taxable` with members `salesTax = 7%` and `incomeTax = 10.5%`. Create abstract method `calcTax()`.

**a.** Create a class **Employee** (`empId`, `name`, `salary`) and implement `Taxable` to calculate incomeTax on yearly salary.

**b.** Create class **Product** (`pid`, `price`, `quantity`) and implement `Taxable` to calculate salesTax on unit price of product.

**c.** Create class for main method (Say `DriverMain`), accept employee information and a product information from the user and print income tax and sales tax respectively.