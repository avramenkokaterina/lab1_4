package main.java.avramenko.library;

import main.java.avramenko.model.ReadTypes;

public class Order {
    private int idOrder;
    private int idReader;
    private String dateStart;
    private String dateFinish;
    private boolean returnChecker;
    private ReadTypes readingPlace;

    public Order(int idOrder, int idReader, String dateStart, String dateFinish, ReadTypes readingPlace, boolean returnChecker) {
        this.idOrder = idOrder;
        this.idReader = idReader;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.readingPlace = readingPlace;
        this.returnChecker = returnChecker;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdReader() {
        return idReader;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public ReadTypes getReadingPlace() {
        return readingPlace;
    }

    public boolean getReturnChecker() {
        return returnChecker;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setReadingPlace(ReadTypes readingPlace) {
        this.readingPlace = readingPlace;
    }

    public void setReturnChecker(boolean returnChecker) {
        this.returnChecker = returnChecker;
    }

    @Override
    public String toString() {
        String str1 = String.format("%7s", idOrder);
        String str4 = String.format("%9s", idReader);
        String str2 = String.format("%21s", dateStart);
        String str3 = String.format("%21s", dateFinish);
        String str5 = String.format("%30s", readingPlace);
        String str6;
        if (returnChecker) {
            str6 = String.format("%11s", "yes");
        } else {
            str6 = String.format("%11s", "no");
        }
        return str1 + str4 + str2 + str3 + str5 + str6;
    }
}

