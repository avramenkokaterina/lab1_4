package main.java.avramenko.model;

public interface Storage {
    //boolean addElement(Object...objects);
    boolean deleteElement(int index);
    Object[] createCatalog();
}
