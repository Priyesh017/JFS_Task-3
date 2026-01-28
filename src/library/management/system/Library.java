package library.management.system;

final class Library {
    final Book[] books;

    String format = "%-10s %-25s %-25s %-10s%n";

    Library() {
        this.books = new Book[10];

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

    void rightShift(int bookIndexToBeAdded) {
        for (int index = actualLength() - 1; index >= bookIndexToBeAdded; index--) {
            books[index + 1] = books[index];
        }
    }

    void leftShift(int bookIndexToBeRemoved) {
        for (int index = bookIndexToBeRemoved; index < books.length - 1; index++) {
            books[index] = books[index + 1];
        }
        books[books.length - 1] = null;
    }

    int binarySearch(int findBookId) {
        int low = 0;
        int high = actualLength() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(books[mid].getBookId() == findBookId) {
                return mid;
            } else if (books[mid].getBookId() > findBookId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    void addBook(Book newBook) {
        int insertAt = actualLength();
        for (int index = 0; index < actualLength(); index++) {
            if (books[index].getBookId() > newBook.getBookId()) {
                insertAt = index;
                break;
            }
        }
        rightShift(insertAt);
        books[insertAt] = newBook;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Book Added Successfully at index: " + insertAt);
        displayBook();
    }

    void removeBook(int bookId) {
        int indexToRemove = binarySearch(bookId);
        if (indexToRemove >= 0) {
            leftShift(indexToRemove);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Book Removed at index: " + indexToRemove);
            displayBook();
        } else {
            System.out.println("Book ID: " + bookId + " not found.");
        }
    }

    void searchBook(int bookId) {
        int foundIndex = binarySearch(bookId);
        if(foundIndex >= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Book Found at index: " + foundIndex);
            System.out.println("------------------------------------------------------------------------");
            System.out.printf(format, "BookID", "Title", "Author", "Available");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf(format, books[foundIndex].getBookId(), books[foundIndex].getTitle(), books[foundIndex].getAuthor(), books[foundIndex].isAvailable() ? "Yes" : "No");
        } else {
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
