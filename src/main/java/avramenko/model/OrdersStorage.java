package main.java.avramenko.model;

import main.java.avramenko.library.Order;

import java.util.Arrays;

public class OrdersStorage implements Storage {
    private Order[] orders;
    private int length;
    private final int initialLength = 10;
    private int currentLength = 0;

    public OrdersStorage() {
        length = initialLength;
        Order[] orders = new Order[length];
    }

    public Order[] getOrders() {
        return orders;
    }


    public boolean addElement(Order... orders) {
        if (this.orders != null && orders != null) {
            if (orders.length <= length - currentLength) {
                for (int i = 0; i < orders.length; i++) {
                    this.orders[currentLength] = orders[i];
                    currentLength++;
                }
                return true;
            } else {
                this.length += orders.length;
                this.orders = Arrays.copyOf(this.orders, length);

                for (int i = 0; i < orders.length; i++) {
                    this.orders[currentLength] = orders[i];
                    currentLength++;
                }
                return true;
            }
        } else {
            if (this.orders == null && orders != null) {
                this.orders = orders;
                this.length = orders.length;
                this.currentLength = this.length;
            }
            return false;
        }
    }

    @Override
    public boolean deleteElement(int index) {
        if (this.orders != null && index < orders.length) {
            for (int i = index; i < length - 1; i++) {
                orders[i] = orders[i + 1];
            }
            return true;
        }
        return false;
    }

    @Override
    public Order[] createCatalog() {
        Order[] orders = new Order[10];
        orders[0] = new Order(1, 7, "01/11/2018", "05/11/2018", ReadTypes.SUBSCRIPTION, true);
        orders[1] = new Order(2, 6, "03/11/2018", "15/11/2018", ReadTypes.READING_ROOM, true);
        orders[2] = new Order(3, 5, "10/11/2018", "13/11/2018", ReadTypes.SUBSCRIPTION, true);
        orders[3] = new Order(4, 4, "02/11/2018", "09/11/2018", ReadTypes.READING_ROOM, true);
        orders[4] = new Order(5, 3, "10/11/2018", "18/11/2018", ReadTypes.SUBSCRIPTION, true);
        orders[5] = new Order(6, 2, "01/11/2018", "01/11/2018", ReadTypes.READING_ROOM, true);
        orders[6] = new Order(7, 1, "08/11/2018", "08/11/2018", ReadTypes.READING_ROOM, true);
        orders[7] = new Order(8, 8, "01/11/2018", "01/12/2018", ReadTypes.SUBSCRIPTION, false);
        orders[8] = new Order(9, 9, "05/11/2018", "05/12/2018", ReadTypes.SUBSCRIPTION, false);
        orders[9] = new Order(10, 10, "10/11/2018", "10/12/2018", ReadTypes.SUBSCRIPTION, false);

        this.orders = orders;
        this.length = orders.length;
        this.currentLength = orders.length;
        return orders;
    }

    public boolean returnBook(int index) {
        boolean checker = this.orders[index-1].getReturnChecker();
        if (this.orders != null && index < orders.length) {
            for (int i = 0; i < length; i++) {
                if (i == index-1) {
                    if (checker) {
                        return false;
                    } else {
                        this.orders[index-1].setReturnChecker(true);
                        return true;
                    }
                }
            }
            return !checker;
        } else {
            return false;
        }
    }
}
