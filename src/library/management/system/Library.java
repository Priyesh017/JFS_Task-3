package library.management.system;

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
