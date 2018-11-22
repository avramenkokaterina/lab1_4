package main.java.avramenko;

import main.java.avramenko.library.*;
import main.java.avramenko.model.*;
import main.java.avramenko.view.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {

    public void startWorking() throws Exception {
        Activities activities;
        View view = new View();
        BooksStorage booksStorage = new BooksStorage();
        ReadersStorage readersStorage = new ReadersStorage();
        OrdersStorage ordersStorage = new OrdersStorage();

        activities = Activities.SHOW_MAIN_MENU_AND_CREATE;
        while (true) {
            switch (activities) {
                case SHOW_MAIN_MENU:
                    activities = showMainMenu(view);
                    break;
                case SHOW_MAIN_MENU_AND_CREATE:
                    activities = showMainMenuAndCreate(view, booksStorage, readersStorage);
                    break;
                case SHOW_CATALOG:
                    activities = showCatalog(view, booksStorage);
                    break;
                case ADD_BOOK:
                    activities = addBook(view, booksStorage);
                    break;
                case DELETE_BOOK:
                    activities = deleteBook(view, booksStorage);
                    break;
                case SHOW_READERS:
                    activities = showReaders(view, readersStorage);
                    break;
                case ADD_READER:
                    activities = addReader(view, readersStorage);
                    break;
                case DELETE_READER:
                    activities = deleteReader(view, readersStorage);
                    break;
                case MANAGE_AND_CREATE:
                    activities = manageAndCreateOrders(view, ordersStorage);
                    break;
                case MANAGE_ORDERS:
                    activities = manageOrders(view);
                    break;
                case SHOW_ORDERS:
                    activities = showOrders(view, ordersStorage);
                    break;
                case MAKE_AN_ORDER:
                    activities = makeOrder(view, ordersStorage);
                    break;
                case RETURN_BOOK:
                    activities = returnBook(view, ordersStorage);
                    break;
                case ADD_TO_BLACK_LIST:
                    activities = addToBlackList(view, readersStorage);
                    break;
                case SHOW_BLACK_LIST:
                    activities = showBlackList(view, readersStorage);
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static Activities convertChoiceToConstant(int choice) {
        switch (choice) {
            case 1:
                return Activities.SHOW_CATALOG;
            case 2:
                return Activities.ADD_BOOK;
            case 3:
                return Activities.DELETE_BOOK;
            case 4:
                return Activities.SHOW_READERS;
            case 5:
                return Activities.ADD_READER;
            case 6:
                return Activities.DELETE_READER;
            case 7:
                return Activities.MANAGE_AND_CREATE;
            case 8:
                return Activities.EXIT;
            case 11:
                return Activities.SHOW_ORDERS;
            case 12:
                return Activities.MAKE_AN_ORDER;
            case 13:
                return Activities.RETURN_BOOK;
            case 14:
                return Activities.ADD_TO_BLACK_LIST;
            case 15:
                return Activities.SHOW_BLACK_LIST;
            case 16:
                return Activities.SHOW_MAIN_MENU;
        }
        return null;
    }

    private Activities showMainMenu(View view) {
        int choice;
        view.menu();
        view.printMessage(Messages.CHOOSE);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_8);
            choice = view.readNumber(1);
        } while (choice > 8);
        return convertChoiceToConstant(choice);
    }

    private Activities showMainMenuAndCreate(View view, BooksStorage booksStorage, ReadersStorage readersStorage) {
        int choice;
        Book[] books;
        books = booksStorage.createCatalog();
        Reader[] readers;
        readers = readersStorage.createCatalog();
        view.menu();
        view.printMessage(Messages.CHOOSE);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_8);
            choice = view.readNumber(1);
        } while (choice > 8);
        return convertChoiceToConstant(choice);
    }

    private Activities showCatalog(View view, BooksStorage booksStorage) {
        Book[] books;
        books = booksStorage.getBooks();
        view.printBooks(books);
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities addBook(View view, BooksStorage booksStorage) {
        boolean isSuccessful;
        String bookTitle;
        String bookAuthor;
        int idBook = booksStorage.getBooks().length;
        view.printMessage(Messages.ENTER_TITLE);
        bookTitle = view.readString();
        view.printMessage(Messages.ENTER_AUTHOR);
        bookAuthor = view.readString();
        Book book = new Book(idBook+1, bookTitle, bookAuthor);
        isSuccessful = booksStorage.addElement(book);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities deleteBook(View view, BooksStorage booksStorage) {
        boolean isSuccessful;
        int index;
        int maxIndex = booksStorage.getBooks().length;
        view.printMessage(Messages.ENTER_ID_BOOK);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_MAX_LENGTH);
            index = view.readNumber(3);
        } while (index > maxIndex);
        isSuccessful = booksStorage.deleteElement(index - 1);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities showReaders(View view, ReadersStorage readersStorage) {
        Reader[] readers;
        readers = readersStorage.getReaders();
        view.printReaders(readers);
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities addReader(View view, ReadersStorage readersStorage) {
        boolean isSuccessful;
        String name;
        String address;
        int idReader = readersStorage.getReaders().length;
        view.printMessage(Messages.ENTER_NAME);
        name = view.readString();
        view.printMessage(Messages.ENTER_ADDRESS);
        address = view.readString();
        Reader reader = new Reader(idReader+1, name, address, false);
        isSuccessful = readersStorage.addElement(reader);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities deleteReader(View view, ReadersStorage readersStorage) {
        boolean isSuccessful;
        int index;
        int maxIndex = readersStorage.getReaders().length;
        view.printMessage(Messages.ENTER_ID_READER);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_MAX_LENGTH);
            index = view.readNumber(3);
        } while (index > maxIndex);
        isSuccessful = readersStorage.deleteElement(index - 1);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.SHOW_MAIN_MENU;
    }

    private Activities manageOrders(View view) {
        int choice;
        view.subMenuForManagingOrders();
        view.printMessage(Messages.CHOOSE);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_6);
            choice = view.readNumber(2);
        } while (choice > 6);
        return convertChoiceToConstant(choice + 10);
    }

    private Activities manageAndCreateOrders(View view, OrdersStorage ordersStorage) {
        int choice;
        Order[] orders;
        orders = ordersStorage.createCatalog();
        view.subMenuForManagingOrders();
        view.printMessage(Messages.CHOOSE);
        do {
            view.printMessage(Messages.ENTER_FROM_1_TO_6);
            choice = view.readNumber(2);
        } while (choice > 6);
        return convertChoiceToConstant(choice + 10);
    }

    private Activities showOrders(View view, OrdersStorage ordersStorage) {
        Order[] orders;
        orders = ordersStorage.getOrders();
        view.printOrders(orders);
        return Activities.MANAGE_ORDERS;
    }

    private Activities makeOrder(View view, OrdersStorage ordersStorage) throws Exception {
        boolean isSuccessful;
        int idReader;
        Calendar c = Calendar.getInstance();
        String dateStart;
        String dateFinish;
        ReadTypes readingPlace;
        int idOrder = ordersStorage.getOrders().length;
        view.printMessage(Messages.ENTER_ID_READER);
        idReader = view.readNumber(3);

        view.printMessage(Messages.ENTER_DATE_START);
        dateStart = view.readString();

        dateFinish = convertDate(dateStart);

        view.printMessage(Messages.ENTER_READ_PLACE);
        int choice = view.readNumber(4);
        if (choice == 1) {
            readingPlace = ReadTypes.READING_ROOM;
        } else {
            readingPlace = ReadTypes.SUBSCRIPTION;
        }
        Order order = new Order(idOrder +1, idReader, dateStart, dateFinish, readingPlace, false);
        isSuccessful = ordersStorage.addElement(order);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
        }
        return Activities.MANAGE_ORDERS;
    }

    private String convertDate(String dateStart) throws Exception{
        Calendar c = Calendar.getInstance();
        String dateFinish;
        SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
        c.setTime(sdf.parse(dateStart));
        c.add(Calendar.MONTH, 1);
        dateFinish = sdf.format(c.getTime());
        return dateFinish;
    }

    private Activities returnBook(View view, OrdersStorage ordersStorage) {
        boolean isSuccessful;
        view.printMessage(Messages.ENTER_ID_ORDER);
        int index = view.readNumber(3);
        isSuccessful = ordersStorage.returnBook(index);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
            view.printMessage(Messages.BOOK_IN_LIBRARY);
        }
        return Activities.MANAGE_ORDERS;
    }

    private Activities addToBlackList(View view, ReadersStorage readersStorage) {
        boolean isSuccessful;
        view.printMessage(Messages.ENTER_ID_READER);
        int index = view.readNumber(3);
        isSuccessful = readersStorage.addToBlackList(index);
        if (isSuccessful) {
            view.printMessage(Messages.SUCCESSFUL);
        } else {
            view.printMessage(Messages.SOMETHING_WRONG);
            view.printMessage(Messages.READER_IN_LIST);
        }
        return Activities.MANAGE_ORDERS;
    }

    private Activities showBlackList(View view, ReadersStorage readersStorage) {
        view.printReaders(readersStorage.createBlackList());
        return Activities.MANAGE_ORDERS;
    }
}
