import java.util.Scanner;

class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final boolean isAvailable;

    Book(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
}


class Library {
    final Book[] books;

    String format = "%-10s %-25s %-25s %-10s%n";

    Library() {
        this.books = new Book[20];

        // Sample Input
        books[0] = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", true);
        books[1] = new Book(102, "1984", "George Orwell", false);
        books[2] = new Book(103, "To Kill a Mockingbird", "Harper Lee", true);
        books[3] = new Book(104, "The Catcher in the Rye", "J.D. Salinger", true);
        books[4] = new Book(105, "Pride and Prejudice", "Jane Austen", false);
        books[5] = new Book(106, "Moby Dick", "Herman Melville", true);
        books[6] = new Book(107, "War and Peace", "Leo Tolstoy", true);
        books[7] = new Book(108, "The Hobbit", "J.R.R. Tolkien", false);
        books[8] = new Book(109, "Crime and Punishment", "Fyodor Dostoevsky", true);
        books[9] = new Book(110, "Brave New World", "Aldous Huxley", true);
    }

    int actualLength() {
        int countActualLength = 0;
        for(Book book: books) {
            if(book != null) {
                countActualLength++;
            }
        }
        return countActualLength;
    }

     void leftShift(int bookIndexToBeRemoved) {
         for (int index = bookIndexToBeRemoved; index < books.length - 1; index++) {
             books[index] = books[index + 1];
         }
         books[books.length - 1] = null;
    }

    void addBook(Book newBook) {
        books[actualLength()] = newBook;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Book Added");
        displayBook();
    }

    void removeBook(int bookId) {
        boolean found = false;
        for (int index = 0; index < books.length; index++) {
            if (books[index] != null && books[index].getBookId() == bookId) {
                leftShift(index);
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Book Removed");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book ID: " + bookId + " not found.");
        } else {
            displayBook();
        }
    }

    void searchBook(int bookId) {
        boolean found = false;
        for (Book book : books) {
            if (book != null && book.getBookId() == bookId) {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Book Found");
                System.out.println("------------------------------------------------------------------------");
                System.out.printf(format, "BookID", "Title", "Author", "Available");
                System.out.println("------------------------------------------------------------------------");
                System.out.printf(format, book.getBookId(), book.getTitle(), book.getAuthor(), book.isAvailable() ? "Yes" : "No");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book ID " + bookId + " not found.");
        }
    }

    void displayBook() {
        if(actualLength() == 0) {
            System.out.println("No Books Available");
            return;
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.printf(format, "BookID", "Title", "Author", "Available");
        System.out.println("------------------------------------------------------------------------");
        for(Book book: books) {
            if(book != null) {
                System.out.printf(format, book.getBookId(), book.getTitle(), book.getAuthor(), book.isAvailable() ? "Yes" : "No");
            }
        }
        System.out.println();
    }
}

public class LibraryManagementSystem {
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
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    if(obj.actualLength() == obj.books.length) {
                        System.out.println("No Space Available");
                        return;
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
                    System.out.print("Enter Book ID to remove: ");
                    int bookId1 = sc.nextInt();
                    obj.removeBook(bookId1);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
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