package main.java.avramenko.view;

import main.java.avramenko.library.*;

import java.util.Scanner;

public class View {
    public void menu() {
        System.out.println("1. Show catalog of books.");
        System.out.println("2. Add book.");
        System.out.println("3. Delete book.");
        System.out.println("4. Show readers.");
        System.out.println("5. Add reader.");
        System.out.println("6. Delete reader.");
        System.out.println("7. Manage Orders.");
        System.out.println("8. Exit.");
    }

    public void subMenuForManagingOrders() {
        System.out.println("1. Show orders.");
        System.out.println("2. Make an order.");
        System.out.println("3. Return a book.");
        System.out.println("4. Add reader to black list.");
        System.out.println("5. Show black list.");
        System.out.println("6. Back to main menu.");
    }

    public void printMessage(Messages messages) {
        switch (messages) {
            case CHOOSE:
                System.out.println("Choose number: ");
                break;
            case ENTER_ID_BOOK:
                System.out.println("Enter book id: ");
                break;
            case ENTER_TITLE:
                System.out.println("Enter book title: ");
                break;
            case ENTER_AUTHOR:
                System.out.println("Enter the author of the book: ");
                break;
            case ENTER_NAME:
                System.out.println("Enter reader name: ");
                break;
            case ENTER_ADDRESS:
                System.out.println("Enter reader address: ");
                break;
            case ENTER_ID_READER:
                System.out.println("Enter reader id: ");
                break;
            case ENTER_DATE_START:
                System.out.println("Enter order date in format dd/MM/yyyy: ");
                break;
            case ENTER_ID_ORDER:
                System.out.println("Enter order id: ");
                break;
            case ENTER_READ_PLACE:
                System.out.println("Choose reading place: 1.library 2.home. Enter 1 or 2.");
                break;
            case NO_RESULTS:
                System.out.println("No records founded. Try again.");
                break;
            case SOMETHING_WRONG:
                System.out.println("Something goes wrong... Try again.");
                break;
            case SUCCESSFUL:
                System.out.println("Successful operation");
                break;
            case BOOK_IN_LIBRARY:
                System.out.println("The book is already in the library.");
                break;
            case READER_IN_LIST:
                System.out.println("The reader is already in the list.");
                break;
            case ENTER_FROM_1_TO_8:
                System.out.println("Enter number from 1 to 8.");
                break;
            case ENTER_FROM_1_TO_6:
                System.out.println("Enter number from 1 to 6.");
                break;
            case ENTER_FROM_1_TO_MAX_LENGTH:
                System.out.println("Enter number from 1 to amounts of elements.");
                break;
            default:
                break;
        }
    }

    public int readNumber(int param) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                switch (param) {
                    case 1:
                        System.out.println("Not a number. Please, choose number from 1 to 8.");
                        sc.next();
                        break;
                    case 2:
                        System.out.println("Not a number. Please, choose number from 1 to 6.");
                        sc.next();
                        break;
                    case 3:
                        System.out.println("Not a number. Please, enter number from 1 to length of catalog.");
                        sc.next();
                        break;
                    case 4:
                        System.out.println("Not a number. Please, enter 1 or 2.");
                        sc.next();
                        break;
                    default:
                        break;
                }
            }
            n = sc.nextInt();
        } while (n < 0);
        return n;
    }

    public String readString() {
        Scanner sc = new Scanner(System.in);
        String string = new String(sc.nextLine());
        return string;
    }

    public void printBooks(Book[] books) {
        System.out.println("Number|                  Name                 |         Author         ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printReaders(Reader[] readers) {
        System.out.println("Number|          Name          |     Address     ");
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    public void printOrders(Order[] orders) {
        System.out.println("Number|Reader Id|     Date Start     |    Date Finish     |        Reading place        | Returned? ");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
