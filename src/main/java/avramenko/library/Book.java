package main.java.avramenko.library;

public class Book {
    private int idBook;
    private String name;
    private String author;

    public Book(int idBook, String name, String author) {
        this.idBook = idBook;
        this.name = name;
        this.author = author;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }


    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        String str1 = String.format("%6s", idBook);
        String str2 = String.format("%40s", name);
        String str3 = String.format("%25s", author);
        return str1 + str2 + str3;
    }

}
