package library.management.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library obj = new Library();
        boolean isContinue = true;
        while(isContinue) {
            System.out.println("\n============= LIBRARY MENU =============");
            System.out.println("1. Add a New Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Display all the Books in thr Library");
            System.out.println("5. Exit Library");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    if(obj.actualLength() == obj.books.length) {
                        System.out.println("Full Library[No Space Available]");
                        break;
                    }
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Available? (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    sc.nextLine();
                    Book newBook = new Book(bookId, title, author, isAvailable);
                    obj.addBook(newBook);
                    break;
                case 2:
                    if(obj.actualLength() == 0) {
                        System.out.println("Empty Library[No Books Present]");
                        break;
                    }
                    System.out.print("Enter Book ID to be remove: ");
                    int bookId1 = sc.nextInt();
                    obj.removeBook(bookId1);
                    break;
                case 3:
                    if(obj.actualLength() == 0) {
                        System.out.println("Empty Library[No Books Present]");
                        break;
                    }
                    System.out.print("Enter Book ID to be searched: ");
                    int bookId2 = sc.nextInt();
                    obj.searchBook(bookId2);
                    break;
                case 4:
                    obj.displayBook();
                    break;
                case 5:
                    isContinue = false;
                    System.out.println("Loop Exited");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}
