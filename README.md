# JFS TASK 2: INTRODUCTION TO OOP IN JAVA
## EXECUTION & PROBLEM GUIDE

This document outlines how to compile and execute the Java OOP assignment and provides a categorized list of all problem statements included in the task set.

---

## 1. HOW TO RUN THE SUBMISSION

The work is structured to demonstrate Object-Oriented concepts. Please follow the instructions below based on the file format.

### OPTION A: Single Menu-Driven File (Recommended)
* Look for a file named `Main.java`.
* **Compile:**
    ```bash
    javac Main.java
    ```
* **Run:**
    ```bash
    java Main
    ```
* **Action:** Enter the letter (**A-D**) to test specific tasks.

### OPTION B: Separate Files (Standard OOP Structure)
* The tasks involve multiple classes (e.g., `Product`, `Employee`).
* You must compile and run each file individually.

---

## 2. PROBLEM STATEMENT CATEGORIES

### TASK A: Person Class Fundamentals
Create a class `Person` with properties (`name` and `age`) and implement the following features:

1.  **Default Age:** Age should default to **18** (using a constructor).
2.  **Initialization:** A person object can be initialized with a specific `name` and `age`.
3.  **Display:** A method to display the name and age of the person.

### TASK B: Product Inventory System
Create a class `Product` (`pid`, `price`, `quantity`) with a parameterized constructor. Create a separate class (e.g., `ProductMain`) with a `main` function to perform the following:


1.  **Storage:** Accept information for **five products** from the user and store them in an array of objects.
2.  **Analysis:** Find the `pid` of the product with the **highest price**.
3.  **Calculation:** Create a static method (accepting the product array) to calculate and return the total amount spent on all products.
    * *Formula:* `Total = Sum of [Price * Quantity] for all items`.

### TASK C: Bank Account Simulation
Create a class `Account` with a data member `Balance`. Implement two constructors (no-argument and with-argument) and perform the following tasks:

1.  Method to **deposit** an amount into the account.
2.  Method to **withdraw** an amount from the account.
3.  Method to **display** the current `Balance`.

### TASK D: Employee Inheritance Model
Define a base class `Person` with attributes `name` and `age`.


1.  Create a subclass `Employee` that **inherits** from `Person`.
2.  Add attributes `employeeID` and `salary` to `Employee`.
3.  Use the `super` keyword in the `Employee` constructor to initialize the inherited `Person` attributes (`name`, `age`).