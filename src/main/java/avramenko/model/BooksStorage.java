package main.java.avramenko.model;

import main.java.avramenko.library.Book;

import java.util.Arrays;

public class BooksStorage implements Storage {

    private Book[] books;
    private int length;
    private final int initialLength = 10;
    private int currentLength = 0;

    public BooksStorage() {
        length = initialLength;
        Book[] books = new Book[length];
    }

    public Book[] getBooks() {
        return books;
    }


    public boolean addElement(Book... books) {
        if (this.books != null && books != null) {
            if (books.length <= length - currentLength) {
                for (int i = 0; i < books.length; i++) {
                    this.books[currentLength] = books[i];
                    currentLength++;
                }
            } else {
                this.length += books.length;
                this.books = Arrays.copyOf(this.books, length);

                for (int i = 0; i < books.length; i++) {
                    this.books[currentLength] = books[i];
                    currentLength++;
                }
            }
            return true;
        } else {
            if (this.books == null && books != null) {
                this.books = books;
                this.length = books.length;
                this.currentLength = this.length;
            }
            return false;
        }
    }

    @Override
    public boolean deleteElement(int index) {
        if (this.books != null && index <= books.length) {
            int indexOfDeleteElement = 0;
            for (int a = 0; a < length; a++) {
                if (index == books[a].getIdBook()) {
                    indexOfDeleteElement = a + 1;
                }
            }
            if (indexOfDeleteElement != length) {
                if (indexOfDeleteElement == 1) {
                    books = Arrays.copyOfRange(books, 1, books.length - 1);
                } else {
                    for (int i = indexOfDeleteElement; i < length - 1; i++) {
                        books[i] = books[i + 1];
                        books[i].setIdBook(i+1);
                    }
                    books = Arrays.copyOf(books, length - 1);
                }
            } else {
                books = Arrays.copyOf(books, length - 1);
            }
            this.books = books;
            this.length = books.length;
            this.currentLength = this.length;
            return true;
        }
        return false;
    }

    @Override
    public Book[] createCatalog() {
        Book[] books = new Book[20];
        books[0] = new Book(1, "In Search of Lost Time", "Marcel Proust");
        books[1] = new Book(2, "Don Quixote", " Miguel de Cervantes");
        books[2] = new Book(3, "Ulysses", "James Joyce");
        books[3] = new Book(4, "The Great Gatsby", "F. Scott Fitzgerald");
        books[4] = new Book(5, "Moby Dick", "Herman Melville");
        books[5] = new Book(6, "Hamlet", "William Shakespeare");
        books[6] = new Book(7, "War and Peace", "Leo Tolstoy");
        books[7] = new Book(8, "The Odyssey", "Homer");
        books[8] = new Book(9, "One Hundred Years of Solitude", "Gabriel Garcia Marquez");
        books[9] = new Book(10, "The Divine Comedy", "Dante Alighieri");
        books[10] = new Book(11, "The Brothers Karamazov", "Fyodor Dostoyevsky");
        books[11] = new Book(12, "Madame Bovary", "Gustave Flaubert");
        books[12] = new Book(13, "The Adventures of Huckleberry Finn", "Mark Twain");
        books[13] = new Book(14, "The Iliad", "Homer");
        books[14] = new Book(15, "Lolita", "Vladimir Nabokov");
        books[15] = new Book(16, "Crime and Punishment", "Fyodor Dostoyevsky");
        books[16] = new Book(17, "Alice's Adventures in Wonderland", "Lewis Carroll");
        books[17] = new Book(18, "Pride and Prejudice", "Jane Austen");
        books[18] = new Book(19, "The Catcher in the Rye", "J. D. Salinger");
        books[19] = new Book(20, "The Sound and the Fury", "William Faulkner");
        this.books = books;
        this.length = books.length;
        this.currentLength = books.length;
        return books;
    }
}
